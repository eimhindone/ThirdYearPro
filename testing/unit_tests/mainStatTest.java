package com.example.livestat;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

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

public class mainStatTest {

    @Rule
    public ActivityTestRule<mainStat> msActivityTestRule = new ActivityTestRule<mainStat>(mainStat.class);

    private mainStat msActivity = null;

    private Instrumentation.ActivityMonitor scoreMonitor = getInstrumentation().addMonitor(Score.class.getName(),null,false);
    private Instrumentation.ActivityMonitor scoreAwayMonitor = getInstrumentation().addMonitor(ScoreAway.class.getName(),null,false);
    private Instrumentation.ActivityMonitor freeMonitor = getInstrumentation().addMonitor(Frees.class.getName(),null,false);
    private Instrumentation.ActivityMonitor freeAgainstMonitor = getInstrumentation().addMonitor(FreesAgainst.class.getName(),null,false);
    private Instrumentation.ActivityMonitor puckoutMonitor = getInstrumentation().addMonitor(Puckout.class.getName(),null,false);
    private Instrumentation.ActivityMonitor puckoutAwayMonitor = getInstrumentation().addMonitor(puckoutAway.class.getName(),null,false);
    private Instrumentation.ActivityMonitor turnoverMonitor = getInstrumentation().addMonitor(Turnover.class.getName(),null,false);

    @Test
    public void testLaunchScore(){
        assertNotNull(msActivity.findViewById(R.id.attemptBtn));
        onView(withId(R.id.attemptBtn)).perform(click());
        Activity score = getInstrumentation().waitForMonitorWithTimeout(scoreMonitor,5000);
        assertNotNull(score);
        score.finish();
    }

    @Test
    public void testLaunchScoreAway(){
        assertNotNull(msActivity.findViewById(R.id.awayAttemptBtn));
        onView(withId(R.id.awayAttemptBtn)).perform(click());
        Activity scoreAway = getInstrumentation().waitForMonitorWithTimeout(scoreAwayMonitor,5000);
        assertNotNull(scoreAway);
        scoreAway.finish();
    }

    @Test
    public void testLaunchFree(){
        assertNotNull(msActivity.findViewById(R.id.freesBtn));
        onView(withId(R.id.freesBtn)).perform(click());
        Activity free = getInstrumentation().waitForMonitorWithTimeout(freeMonitor,5000);
        assertNotNull(free);
        free.finish();
    }

    @Test
    public void testLaunchFreeAway(){
        assertNotNull(msActivity.findViewById(R.id.freesABtn));
        onView(withId(R.id.freesABtn)).perform(click());
        Activity freeAway = getInstrumentation().waitForMonitorWithTimeout(freeAgainstMonitor,5000);
        assertNotNull(freeAway);
        freeAway.finish();
    }

    @Test
    public void testLaunchPuckout(){
        assertNotNull(msActivity.findViewById(R.id.puckoutBtn));
        onView(withId(R.id.puckoutBtn)).perform(click());
        Activity puckout = getInstrumentation().waitForMonitorWithTimeout(puckoutMonitor,5000);
        assertNotNull(puckout);
        puckout.finish();
    }

    @Test
    public void testLaunchPuckoutAway(){
        assertNotNull(msActivity.findViewById(R.id.puckoutABtn));
        onView(withId(R.id.puckoutABtn)).perform(click());
        Activity puckoutAway = getInstrumentation().waitForMonitorWithTimeout(puckoutAwayMonitor,5000);
        assertNotNull(puckoutAway);
        puckoutAway.finish();
    }

    @Test
    public void testLaunchTurnover(){
        assertNotNull(msActivity.findViewById(R.id.turnoverBtn));
        onView(withId(R.id.turnoverBtn)).perform(click());
        Activity turnover = getInstrumentation().waitForMonitorWithTimeout(turnoverMonitor,5000);
        assertNotNull(turnover);
        turnover.finish();
    }

    @Before
    public void setUp() throws Exception {
        msActivity = msActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        msActivity = null;
    }
}