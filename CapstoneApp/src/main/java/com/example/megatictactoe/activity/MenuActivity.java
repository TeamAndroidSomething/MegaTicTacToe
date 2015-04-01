package com.example.megatictactoe.activity;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.example.megatictactoe.megatictactoe.R;


public class MenuActivity extends Activity implements View.OnClickListener {

    Boolean Layoutstate = false;
    View lsizesLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Finding all of the Views
        View bNewGame = this.findViewById(R.id.bNewGame);
        View bSelectSize = this.findViewById(R.id.bSelectSize);
        View b15x15 = this.findViewById(R.id.b15x15);
        View b19x19 = this.findViewById(R.id.b19x19);
        View b24x24 = this.findViewById(R.id.b24x24);
        View bExit = this.findViewById(R.id.bExit);

        lsizesLayout = this.findViewById(R.id.lsizesLayout);

        // adds on click listeners to each object that needs it
        bNewGame.setOnClickListener(this);
        bSelectSize.setOnClickListener(this);
        b15x15.setOnClickListener(this);
        b19x19.setOnClickListener(this);
        b24x24.setOnClickListener(this);
        bExit.setOnClickListener(this);

        //hides the size layout to start
        lsizesLayout.setVisibility(View.GONE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        // switches off the View ID it is given
        switch (v.getId()){

            case R.id.bSelectSize: {
                if (Layoutstate){
                    lsizesLayout.setVisibility(View.GONE);
                    Layoutstate = false;
                } else {
                    lsizesLayout.setVisibility(View.VISIBLE);
                    Layoutstate = true;
                }

                break;
            }

            case R.id.bNewGame:{

                Intent myIntent = new Intent(MenuActivity.this, GameActivity.class);
                MenuActivity.this.startActivity(myIntent);
            }

            case R.id.bExit:{
                finish();
                break;
            }




        }
    }
}
