package com.example.megatictactoe.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import com.example.megatictactoe.megatictactoe.R;


public class MainActivity extends Activity {
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // delays 5 seconds then launches the MenuActivity
        mHandler.postDelayed(new Runnable() {
            public void run() {
                //Intent myIntent = new Intent(MainActivity.this, MenuActivity.class);
                Intent myIntent = new Intent(MainActivity.this, MenuActivity.class);
                MainActivity.this.startActivity(myIntent);
                MainActivity.this.finish();
            }
        }, 5000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
