/*
 * Copyright 2016 Dominion Enterprises. All Rights Reserved.
 */

package com.dominion.mobile.ddsrefactortest.api.entities;

import java.io.Serializable;

/**
 * Represents a user
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class User implements Serializable
{
    public int getId()
    {
        return id;
    }
    
    public void setId( final int id )
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName( final String name )
    {
        this.name = name;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername( final String username )
    {
        this.username = username;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail( final String email )
    {
        this.email = email;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    public void setAddress( final Address address )
    {
        this.address = address;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone( final String phone )
    {
        this.phone = phone;
    }
    
    public String getWebsite()
    {
        return website;
    }
    
    public void setWebsite( final String website )
    {
        this.website = website;
    }
    
    public Company getCompany()
    {
        return company;
    }
    
    public void setCompany( final Company company )
    {
        this.company = company;
    }
    
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}