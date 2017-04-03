/*
 * Copyright 2016 Dominion Enterprises. All Rights Reserved.
 */

package com.dominion.mobile.ddsrefactortest.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Represents the geo location of a user
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Geo implements Serializable
{
    public String getLatitude()
    {
        return latitude;
    }
    
    public void setLatitude( final String latitude )
    {
        this.latitude = latitude;
    }
    
    public String getLongitude()
    {
        return longitude;
    }
    
    public void setLongitude( final String longitude )
    {
        this.longitude = longitude;
    }
    
    @JsonProperty( "lat" ) private String latitude;
    @JsonProperty( "lng" ) private String longitude;
    
}