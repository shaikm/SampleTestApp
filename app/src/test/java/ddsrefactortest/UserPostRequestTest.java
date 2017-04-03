package ddsrefactortest;

import com.dominion.mobile.ddsrefactortest.BuildConfig;
import com.dominion.mobile.ddsrefactortest.api.UserPostsRequest;
import com.dominion.mobile.ddsrefactortest.api.UserPostsResponse;
import com.dominion.mobile.ddsrefactortest.api.entities.User;
import com.octo.android.robospice.Jackson2SpringAndroidSpiceService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class UserPostRequestTest {

    private UserPostsRequest springAndroidRequest;
    private final int USER_ID = 2;

    @Before
    public void setup() {
        ShadowLog.stream = System.out; //This is for printing log messages in console
        //This is to mock the user object so it always returns the given user id whenever we call user.getId
        User user = Mockito.mock(User.class);
        when(user.getId()).thenReturn(USER_ID);

        ShadowLog.d("User Id is", "User Id : " + user.getId());
        assertEquals(user.getId(), USER_ID);
        springAndroidRequest = new UserPostsRequest(user.getId());
    }

    @Test
    public void testUserPostRequest() {
        Jackson2SpringAndroidSpiceService service = new Jackson2SpringAndroidSpiceService();
        service.createRestTemplate();
        UserPostsResponse response = null;
        try {
            response = springAndroidRequest.loadDataFromNetwork();
            assertEquals(response.size(), 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}