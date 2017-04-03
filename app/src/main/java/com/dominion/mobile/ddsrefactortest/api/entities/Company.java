/*
 * Copyright 2016 Dominion Enterprises. All Rights Reserved.
 */

package com.dominion.mobile.ddsrefactortest.api.entities;

import java.io.Serializable;

/**
 * Represents a company
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Company implements Serializable
{
    public String getName()
    {
        return name;
    }
    
    public void setName( final String name )
    {
        this.name = name;
    }
    
    public String getCatchPhrase()
    {
        return catchPhrase;
    }
    
    public void setCatchPhrase( final String catchPhrase )
    {
        this.catchPhrase = catchPhrase;
    }
    
    public String getBs()
    {
        return bs;
    }
    
    public void setBs( final String bs )
    {
        this.bs = bs;
    }
    
    private String name;
    private String catchPhrase;
    private String bs;
}