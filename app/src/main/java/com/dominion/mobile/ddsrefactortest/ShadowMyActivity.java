package com.dominion.mobile.ddsrefactortest;

import com.dominion.mobile.ddsrefactortest.api.entities.User;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.shadows.ShadowActivity;

@Implements(UserPostsActivity.class)
public class ShadowMyActivity extends ShadowActivity
{
    @RealObject
    private UserPostsActivity myActivity;

    @Implementation
    public void setForMockito(User user)
    {
        myActivity.user = user;
    }
}
