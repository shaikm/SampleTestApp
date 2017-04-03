/*
 * Copyright 2016 Dominion Enterprises. All Rights Reserved.
 */

package com.dominion.mobile.ddsrefactortest.api.entities;

/**
 * Represents a user's post
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Post
{
    public int getId()
    {
        return id;
    }
    
    public void setId( final int id )
    {
        this.id = id;
    }
    
    public int getUserId()
    {
        return userId;
    }
    
    public void setUserId( final int userId )
    {
        this.userId = userId;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle( final String title )
    {
        this.title = title;
    }
    
    public String getBody()
    {
        return body;
    }
    
    public void setBody( final String body )
    {
        this.body = body;
    }
    
    private int id;
    private int userId;
    private String title;
    private String body;
}