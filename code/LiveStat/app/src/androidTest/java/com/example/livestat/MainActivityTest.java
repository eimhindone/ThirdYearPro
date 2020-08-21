package com.example.livestat;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertNotNull;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    private Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(EnterPin.class.getName(),null,false);
    private Instrumentation.ActivityMonitor statMonitor = getInstrumentation().addMonitor(CreateGame.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = mActivity.findViewById(R.id.managerBtn);
        assertNotNull(view);
    }

    @Test
    public void testLaunchEnterPinOnButtonClick(){
        assertNotNull(mActivity.findViewById(R.id.managerBtn));
        onView(withId(R.id.managerBtn)).perform(click());
        Activity enterPin = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(enterPin);
        enterPin.finish();
    }

    @Test
    public void testLaunchCreateGameOnButtonClick() {
        assertNotNull(mActivity.findViewById(R.id.statisticsTakerBtn));
        onView(withId(R.id.statisticsTakerBtn)).perform(click());
        Activity createGame = getInstrumentation().waitForMonitorWithTimeout(statMonitor,5000);
        assertNotNull(createGame);
        createGame.finish();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}