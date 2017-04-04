/*
 * Copyright 2016 Dominion Enterprises. All Rights Reserved.
 */

package ddsrefactortest;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import android.widget.ListView;

import com.dominion.mobile.ddsrefactortest.BuildConfig;
import com.dominion.mobile.ddsrefactortest.R;
import com.dominion.mobile.ddsrefactortest.UsersActivity;
import com.dominion.mobile.ddsrefactortest.api.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.res.builder.RobolectricPackageManager;
import org.robolectric.shadows.ShadowListView;
import org.robolectric.shadows.ShadowLog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class UsersActivityTest {

    private static final String FIRST_USER_NAME = "Leanne Graham";
    private static final String LOG_TAG =UsersActivityTest.class.getName() ;
    private UsersActivity mActivity;
    private ListView listView;
    @Mock
    private RobolectricPackageManager rpm;

    @Before
    public void setup() {
        mActivity = Robolectric.setupActivity(UsersActivity.class);
        rpm = (RobolectricPackageManager) RuntimeEnvironment.application.getPackageManager();
        rpm.addResolveInfoForIntent(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS), new ResolveInfo());
        assertNotNull("Mainactivity not intsantiated",mActivity);
        listView=(ListView)mActivity.findViewById(R.id.users);//getting the list layout xml
        ShadowLog.stream = System.out; //This is for printing log messages in console
    }

    @Test
    public void listViewTestWithCount() throws InterruptedException {
        assertNotNull("ListView not found ", listView);
        ShadowListView listview = Shadows.shadowOf(listView);
        listview.populateItems();
        Thread.sleep(5000);
        ShadowLog.d(LOG_TAG, "Count is" + listView.getAdapter().getCount());
        assertEquals(listView.getAdapter().getCount(), 10);
    }

    @Test
    public void listViewTestFirstItem() throws InterruptedException {
        assertNotNull("ListView not found ", listView);
        ShadowListView listview = Shadows.shadowOf(listView);
        listview.populateItems();
        Thread.sleep(5000);
        ShadowLog.d(LOG_TAG, "User Name is" + ((User)listView.getAdapter().getItem(0)).getName());
        assertEquals(((User)listView.getAdapter().getItem(0)).getName(), FIRST_USER_NAME);
    }

}