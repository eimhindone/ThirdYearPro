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
import static org.junit.Assert.*;

public class TurnoverTest {

    @Rule
    public ActivityTestRule<Turnover> tActivityTestRule = new ActivityTestRule<Turnover>(Turnover.class);

    private Turnover tActivity = null;

    private Instrumentation.ActivityMonitor tMonitor = getInstrumentation().addMonitor(PitchActivity.class.getName(),null,false);
    private Instrumentation.ActivityMonitor tMonitorBad = getInstrumentation().addMonitor(PitchActivityBad.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        tActivity = tActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchPitchActivityOnForButtonClick(){
        assertNotNull(tActivity.findViewById(R.id.ballwonBtn));
        onView(withId(R.id.ballwonBtn)).perform(click());
        Activity turnoverPitchActivity = getInstrumentation().waitForMonitorWithTimeout(tMonitor,5000);
        assertNotNull(turnoverPitchActivity);
        turnoverPitchActivity.finish();
    }

    @Test
    public void testLaunchPitchActivityOnAgainstButtonClick(){
        assertNotNull(tActivity.findViewById(R.id.balllostBtn));
        onView(withId(R.id.balllostBtn)).perform(click());
        Activity turnoverPitchActivityBad = getInstrumentation().waitForMonitorWithTimeout(tMonitorBad,5000);
        assertNotNull(turnoverPitchActivityBad);
        turnoverPitchActivityBad.finish();
    }

    @Test
    public void testLaunch(){
        View view = tActivity.findViewById(R.id.ballwonBtnM);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        tActivity = null;
    }
}