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

import com.dominion.mobile.ddsrefactortest.R;
import com.dominion.mobile.ddsrefactortest.api.entities.Post;

import java.util.List;

/**
 * Adapter to display posts from a user
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class UserPostsAdapter extends ArrayAdapter<Post>
{
    public UserPostsAdapter( @NonNull Context context, @NonNull List<Post> posts )
    {
        super( context, LAYOUT, posts );
    }
    
    @Override
    public View getView( int position, @Nullable View view, ViewGroup parent )
    {
        UserPostsViewHolder viewHolder;
        
        if( view == null )
        {
            view = ( (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE ) ).inflate( LAYOUT, parent, false );
            
            viewHolder = new UserPostsViewHolder();
            viewHolder.title = (TextView) view.findViewById( R.id.title );
            viewHolder.body = (TextView) view.findViewById( R.id.body );
            
            view.setTag( viewHolder );
        }
        else
        {
            viewHolder = (UserPostsViewHolder) view.getTag();
        }
        
        Post post = getItem( position );
        
        viewHolder.title.setText( post.getTitle() );
        viewHolder.body.setText( post.getBody() );
        
        return view;
    }
    
    private static class UserPostsViewHolder
    {
        TextView title;
        TextView body;
    }
    
    private static final int LAYOUT = R.layout.listitem_user_post;
}