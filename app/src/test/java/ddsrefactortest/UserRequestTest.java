package ddsrefactortest;

import com.dominion.mobile.ddsrefactortest.BuildConfig;
import com.dominion.mobile.ddsrefactortest.api.UsersRequest;
import com.dominion.mobile.ddsrefactortest.api.UsersResponse;
import com.octo.android.robospice.Jackson2SpringAndroidSpiceService;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class UserRequestTest {

    private UsersRequest springAndroidRequest;

    @Before
    public void setup() {
        ShadowLog.stream = System.out; //This is for printing log messages in console
        springAndroidRequest = new UsersRequest();
    }

    @Test
    public void testUserRequest() {
        Jackson2SpringAndroidSpiceService service = new Jackson2SpringAndroidSpiceService();
        service.createRestTemplate();
        UsersResponse catReturned = null;
        try {
            catReturned = springAndroidRequest.loadDataFromNetwork();
            assertEquals(catReturned.size(), 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}