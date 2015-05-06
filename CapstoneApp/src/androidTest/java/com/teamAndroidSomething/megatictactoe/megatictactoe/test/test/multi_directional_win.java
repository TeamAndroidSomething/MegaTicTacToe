package com.teamAndroidSomething.megatictactoe.megatictactoe.test.test;

import com.teamAndroidSomething.megatictactoe.activity.SplashActivity;
import com.teamAndroidSomething.megatictactoe.activity.MenuActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;

/*
    1. multi-directional-win-x
    2. o-winning
    3. does-not-win-on-6
    4. win-check-four-boundaries
    5. menu-buttons-function-test
 */

public class multi_directional_win extends ActivityInstrumentationTestCase2<SplashActivity> {
  	private Solo solo;
  	
  	public multi_directional_win() {
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
        //Take screenshot
        solo.takeScreenshot();
        //Take screenshot
        solo.takeScreenshot();
        //Take screenshot
        solo.takeScreenshot();
        //Take screenshot
        solo.takeScreenshot();
        //Take screenshot
        solo.takeScreenshot();
        //Wait for activity: 'com.teamAndroidSomething.megatictactoe.activity.SplashActivity'
		solo.waitForActivity(SplashActivity.class, 2000);
        //Wait for activity: 'com.teamAndroidSomething.megatictactoe.activity.MenuActivity'
		assertTrue("com.teamAndroidSomething.megatictactoe.activity.MenuActivity is not found!", solo.waitForActivity(MenuActivity.class));
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
        //Wait for activity: 'com.teamAndroidSomething.megatictactoe.activity.GameActivity'
		assertTrue("com.teamAndroidSomething.megatictactoe.activity.GameActivity is not found!", solo.waitForActivity(com.teamAndroidSomething.megatictactoe.activity.GameActivity.class));
        //Set default small timeout to 14141 milliseconds
		Timeout.setSmallTimeout(14141);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 46));
        //Click on (235.0, 634.0)
		solo.clickOnScreen(235.0F, 634.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 61));
        //Click on (252.0, 803.18427)
		solo.clickOnScreen(252.0F, 803.18427F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 92));
        //Click on (424.0, 1084.0)
		solo.clickOnScreen(424.0F, 1084.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 62));
        //Click on (396.0, 842.0)
		solo.clickOnScreen(396.0F, 842.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 47));
        //Click on (427.0, 617.0)
		solo.clickOnScreen(427.0F, 617.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 64));
        //Click on (727.0, 797.0)
		solo.clickOnScreen(727.0F, 797.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 35));
        //Click on (848.0, 471.0)
		solo.clickOnScreen(848.0F, 471.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 48));
        //Click on (578.0, 648.0524)
		solo.clickOnScreen(578.0F, 648.0524F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 108));
        //Click on (567.0, 1270.0)
		solo.clickOnScreen(567.0F, 1270.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 77));
        //Click on (415.0, 980.0)
		solo.clickOnScreen(415.0F, 980.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 76));
        //Click on (213.0, 944.0)
		solo.clickOnScreen(213.0F, 944.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 65));
        //Click on (874.0, 795.0)
		solo.clickOnScreen(874.0F, 795.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 78));
        //Click on (587.0, 955.0)
		solo.clickOnScreen(587.0F, 955.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 91));
        //Click on (218.0238, 1107.0)
		solo.clickOnScreen(218.0238F, 1107.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 106));
        //Click on (235.0, 1318.0)
		solo.clickOnScreen(235.0F, 1318.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 49));
        //Click on (744.0, 643.0)
		solo.clickOnScreen(744.0F, 643.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 32));
        //Drag from (382.0, 468.0) to (373.0, 463.0)
		solo.drag(382.0F, 373.0F, 468.0F, 463.0F, 40);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 105));
        //Click on (95.0, 1267.0)
		solo.clickOnScreen(95.0F, 1267.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 122));
        //Click on (398.0, 1453.0)
		solo.clickOnScreen(398.0F, 1453.0F);
        //Long click ImageView
		solo.clickLongOnView(solo.getView(android.widget.ImageButton.class, 63));
        //Wait for dialog
		solo.waitForDialogToOpen(5000);
        //Click on (581.0, 806.0)
		solo.clickOnScreen(581.0F, 806.0F);
        //Wait for dialog to close
		solo.waitForDialogToClose(5000);
	}
}
