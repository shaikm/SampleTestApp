/*
 * Copyright 2016 Dominion Enterprises. All Rights Reserved.
 */

package com.dominion.mobile.ddsrefactortest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dominion.mobile.ddsrefactortest.api.entities.User;

import java.util.List;

/**
 * Adapter to display users
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class UsersAdapter extends ArrayAdapter<User>
{
    /**
     * Creates a new instance of UsersAdapter
     *
     * @param context the current context
     * @param users the list of users
     *
     * @since 1.0.0
     */
    public UsersAdapter( @NonNull Context context, @NonNull List<User> users )
    {
        super( context, LAYOUT, users );
    }
    
    @Override
    public View getView( int position, @Nullable View view, ViewGroup parent )
    {
        UserViewHolder viewHolder;
        
        if( view == null )
        {
            view = ( (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE ) ).inflate( LAYOUT, parent, false );
            
            viewHolder = new UserViewHolder();
            viewHolder.name = (TextView) view.findViewById( android.R.id.text1 );
            
            view.setTag( viewHolder );
        }
        else
        {
            viewHolder = (UserViewHolder) view.getTag();
        }
        
        User user = getItem( position );
        
        viewHolder.name.setText( user.getName() );
        
        return view;
    }
    
    private static class UserViewHolder
    {
        TextView name;
    }
    
    private static final int LAYOUT = android.R.layout.simple_list_item_1;
}