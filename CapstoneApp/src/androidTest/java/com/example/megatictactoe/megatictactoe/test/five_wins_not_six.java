package com.example.megatictactoe.megatictactoe.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.megatictactoe.activity.MenuActivity;
import com.example.megatictactoe.activity.SplashActivity;
import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

/*
    1. multi-directional-win-x
    2. o-winning
    3. does-not-win-on-6
    4. win-check-four-boundaries
    5. menu-buttons-function-test
 */

public class five_wins_not_six extends ActivityInstrumentationTestCase2<SplashActivity> {
  	private Solo solo;

  	public five_wins_not_six() {
		super(SplashActivity.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'com.example.megatictactoe.activity.SplashActivity'
		solo.waitForActivity(SplashActivity.class, 2000);
        //Wait for activity: 'com.example.megatictactoe.activity.MenuActivity'
		assertTrue("com.example.megatictactoe.activity.MenuActivity is not found!",
                solo.waitForActivity(MenuActivity.class));
        //Click on (502.0, 440.0)
		solo.clickOnScreen(502.0F, 440.0F);
        //Click on (320.0, 634.0)
		solo.clickOnScreen(320.0F, 634.0F);
        //Click on (452.0, 451.0)
		solo.clickOnScreen(452.0F, 451.0F);
        //Set default small timeout to 10564 milliseconds
		Timeout.setSmallTimeout(10564);
        //Click on (429.0, 159.0)
		solo.clickOnScreen(429.0F, 159.0F);
        //Wait for activity: 'com.example.megatictactoe.activity.GameActivity'
		assertTrue("com.example.megatictactoe.activity.GameActivity is not found!",
                solo.waitForActivity(com.example.megatictactoe.activity.GameActivity.class));
        //Set default small timeout to 14141 milliseconds
		Timeout.setSmallTimeout(14141);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 46));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 61));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 47));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 62));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 48));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 63));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 49));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 64));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 51));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 77));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 50));
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 65));
        //Wait for dialog
        assertTrue("Win dialog appears", solo.waitForDialogToOpen(5000));
        //Dialog states that X won
        assertTrue("Dialog states O wins", solo.searchText("O wins!"));
	}
}
