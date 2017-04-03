/*
 * Copyright 2016 Dominion Enterprises. All Rights Reserved.
 */

package com.dominion.mobile.ddsrefactortest.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Represents a user address
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Address implements Serializable
{
    public String getStreet()
    {
        return street;
    }
    
    public void setStreet( final String street )
    {
        this.street = street;
    }
    
    public String getSuite()
    {
        return suite;
    }
    
    public void setSuite( final String suite )
    {
        this.suite = suite;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity( final String city )
    {
        this.city = city;
    }
    
    public String getZipcode()
    {
        return zipcode;
    }
    
    public void setZipcode( final String zipcode )
    {
        this.zipcode = zipcode;
    }
    
    public Geo getLocation()
    {
        return location;
    }
    
    public void setLocation( final Geo location )
    {
        this.location = location;
    }
    
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @JsonProperty( "geo" ) private Geo location;
}