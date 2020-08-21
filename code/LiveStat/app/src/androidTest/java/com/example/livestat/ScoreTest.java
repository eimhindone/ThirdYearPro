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

public class ScoreTest {

    @Rule
    public ActivityTestRule<Score> sActivityTestRule = new ActivityTestRule<Score>(Score.class);

    private Score sActivity = null;

    private Instrumentation.ActivityMonitor sMonitor = getInstrumentation().addMonitor(PitchActivity.class.getName(),null,false);
    private Instrumentation.ActivityMonitor sMonitorBad = getInstrumentation().addMonitor(PitchActivityBad.class.getName(),null,false);
    private Instrumentation.ActivityMonitor negSMonitorBad = getInstrumentation().addMonitor(PitchActivityBad.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        sActivity = sActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view = sActivity.findViewById(R.id.missBtnM);
        assertNotNull(view);
    }

    @Test
    public void testLaunchPitchActivityOnClickForGoodEvent() {
        assertNotNull(sActivity.findViewById(R.id.homegoalBtn));
        onView(withId(R.id.homegoalBtn)).perform(click());
        Activity pitchActivity = getInstrumentation().waitForMonitorWithTimeout(sMonitor,5000);
        assertNotNull(pitchActivity);
        pitchActivity.finish();
    }

    @Test
    public void testLaunchPitchActivityBadOnClickForBadEvent () {
        assertNotNull(sActivity.findViewById(R.id.missBtn));
        onView(withId(R.id.missBtn)).perform(click());
        Activity pitchActivityBad = getInstrumentation().waitForMonitorWithTimeout(sMonitorBad,5000);
        assertNotNull(pitchActivityBad);
        pitchActivityBad.finish();
    }



    @After
    public void tearDown() throws Exception {
        sActivity = null;
    }
}