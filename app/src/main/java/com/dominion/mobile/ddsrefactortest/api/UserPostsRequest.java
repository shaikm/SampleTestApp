/*
 * Copyright 2016 Dominion Enterprises. All Rights Reserved.
 */

package com.dominion.mobile.ddsrefactortest.api;

import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Request to fetch posts from a specific user
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class UserPostsRequest extends SpringAndroidSpiceRequest<UserPostsResponse>
{
    /**
     * Creates a new instance of UsersRequest
     *
     * @param userId the ID of the user
     *
     * @since 1.0.0
     */
    public UserPostsRequest( int userId )
    {
        super( UserPostsResponse.class );
        
        this.userId = userId;
    }
    
    @Override
    public UserPostsResponse loadDataFromNetwork() throws Exception
    {
        RestTemplate template = getRestTemplate();
        
        if( template == null )
        {
            template = new RestTemplate( true );
        }
        
        template.getMessageConverters().add( new StringHttpMessageConverter() );
        
        final ClientHttpRequestFactory factory = template.getRequestFactory();
        
        int timeout = 10000; // 10 seconds
        
        // set default connection timeout
        if( factory instanceof HttpComponentsClientHttpRequestFactory )
        {
            final HttpComponentsClientHttpRequestFactory advancedFactory = (HttpComponentsClientHttpRequestFactory) factory;
            advancedFactory.setConnectTimeout( timeout );
            advancedFactory.setReadTimeout( timeout );
        }
        else if( factory instanceof SimpleClientHttpRequestFactory )
        {
            final SimpleClientHttpRequestFactory advancedFactory = (SimpleClientHttpRequestFactory) factory;
            advancedFactory.setConnectTimeout( timeout );
            advancedFactory.setReadTimeout( timeout );
        }
        
        return template.exchange( "https://jsonplaceholder.typicode.com/posts?userId=" + userId,
                                  HttpMethod.GET,
                                  null,
                                  UserPostsResponse.class ).getBody();
    }
    
    private final int userId;
}
