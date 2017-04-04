package ddsrefactortest;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ListView;

import com.dominion.mobile.ddsrefactortest.BuildConfig;
import com.dominion.mobile.ddsrefactortest.R;
import com.dominion.mobile.ddsrefactortest.UserPostsActivity;
import com.dominion.mobile.ddsrefactortest.api.entities.Post;
import com.dominion.mobile.ddsrefactortest.api.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowListView;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class UserPostActivityTest {

    private static final String FIRST_POST_NAME = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
    private static final String LOG_TAG =UserPostActivityTest.class.getName() ;
    private UserPostsActivity mActivity;
    private ListView listView;
    private ActivityController<UserPostsActivity> controller;


    @Before
    public void setup() {
        User user =new User();
        user.setId(1);
        Intent intent = new Intent(RuntimeEnvironment.application.getApplicationContext(), UserPostsActivity.class);
        intent.putExtra("extra_user", user);
        controller = Robolectric.buildActivity(UserPostsActivity.class).withIntent(intent).create().start().resume().stop().destroy();
        mActivity = controller.get();

        assertNotNull("Activity not null",mActivity);
        listView=(ListView)mActivity.findViewById(R.id.posts);//getting the list layout xml
        ShadowLog.stream = System.out; //This is for printing log messages in console
    }

    @Test
    public void listViewPostActivityTestWithCount() throws InterruptedException {
        assertNotNull("ListView not found ", listView);
        ShadowListView listview = Shadows.shadowOf(listView);
        listview.populateItems();
        Thread.sleep(5000);
        ShadowLog.d(LOG_TAG, "Post Count is" + listView.getAdapter().getCount());
        assertEquals(listView.getAdapter().getCount(), 10);
    }

    @Test
    public void listViewPostActivityTestFirstItem() throws InterruptedException {
        assertNotNull("ListView not found ", listView);
        ShadowListView listview = Shadows.shadowOf(listView);
        listview.populateItems();
        Thread.sleep(5000);
        ShadowLog.d(LOG_TAG, "Post title is  " + ((Post)listView.getAdapter().getItem(0)).getTitle());
        assertEquals(((Post)listView.getAdapter().getItem(0)).getTitle(), FIRST_POST_NAME);
    }

}