/*
 * Copyright 2016 Dominion Enterprises. All Rights Reserved.
 */

package com.dominion.mobile.ddsrefactortest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.dominion.mobile.ddsrefactortest.adapters.UsersAdapter;
import com.dominion.mobile.ddsrefactortest.api.UsersRequest;
import com.dominion.mobile.ddsrefactortest.api.UsersResponse;
import com.dominion.mobile.ddsrefactortest.api.entities.User;
import com.octo.android.robospice.Jackson2SpringAndroidSpiceService;
import com.octo.android.robospice.JacksonSpringAndroidSpiceService;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity that lists all current users
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class UsersActivity extends Activity
{

    private UsersRequest userRequest;

    @Override
    protected void onCreate( final Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_users );

        adapter = new UsersAdapter( this, users );
        userRequest = new UsersRequest();
        
        ListView listView = (ListView) findViewById( R.id.users );
        listView.setAdapter( adapter );
        listView.setOnItemClickListener( new OnItemClickListener()
        {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int position, long id )
            {
                Intent intent = new Intent( UsersActivity.this, UserPostsActivity.class );
                intent.putExtra( UserPostsActivity.EXTRA_USER, users.get( position ) );
                
                startActivity( intent );
            }
        } );


        
        loadingIndicator = (ProgressBar) findViewById( R.id.loading_indicator );
    }
    
    @Override
    protected void onStart()
    {
        super.onStart();
        
    }
    
    @Override
    protected void onResume()
    {
        super.onResume();
        
        loadingIndicator.setVisibility( View.VISIBLE );

        Jackson2SpringAndroidSpiceService service = new Jackson2SpringAndroidSpiceService();
        service.createRestTemplate();
        UsersResponse response = null;
        try {

            response = userRequest.loadDataFromNetwork();
            users.addAll( response );

            adapter.notifyDataSetChanged();

            loadingIndicator.setVisibility( View.INVISIBLE );
        } catch (Exception e) {
            e.printStackTrace();
            loadingIndicator.setVisibility( View.INVISIBLE );

            new AlertDialog.Builder( UsersActivity.this ).setTitle( R.string.error ).setMessage( R.string.something_went_wrong ).show();
        }

    }
    
    @Override
    protected void onStop()
    {

        super.onStop();
    }

    
    private UsersAdapter adapter;
    private ProgressBar loadingIndicator;

    private final List<User> users = new ArrayList<>();
}