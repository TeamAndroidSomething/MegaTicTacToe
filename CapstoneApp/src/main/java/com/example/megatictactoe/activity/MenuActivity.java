package com.example.megatictactoe.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.example.megatictactoe.megatictactoe.R;


public class MenuActivity extends Activity implements View.OnClickListener {

    int TILE_SIZE;
    Boolean TileSelectorLayoutVisible = false;
    View LSizesLayout;

    Button bNewGame;
    Button bResumeGame;
    Button buttonSelectSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        // Finding all of the Views
        bNewGame = (Button)findViewById(R.id.bNewGame);
        bResumeGame = (Button)findViewById(R.id.bResumeGame);
        buttonSelectSize = (Button) findViewById(R.id.bSelectSize);
        View b15x15 = this.findViewById(R.id.b15x15);
        View b19x19 = this.findViewById(R.id.b19x19);
        View b24x24 = this.findViewById(R.id.b24x24);
        View bExit = this.findViewById(R.id.bExit);
        LSizesLayout = this.findViewById(R.id.lsizesLayout);

        // adds on click listeners to each object that needs it
        bNewGame.setOnClickListener(this);
        bResumeGame.setOnClickListener(this);
        buttonSelectSize.setOnClickListener(this);
        b15x15.setOnClickListener(this);
        b19x19.setOnClickListener(this);
        b24x24.setOnClickListener(this);
        bExit.setOnClickListener(this);

        // Disables the New Game Button to start
        bNewGame.setEnabled(false);
        bNewGame.setBackground(getResources().getDrawable(R.drawable.new_game_disabled));

        // Hides Resume Game Button to start
        bResumeGame.setVisibility(View.GONE);

        //hides the size layout to start
        LSizesLayout.setVisibility(View.GONE);
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
                if (TileSelectorLayoutVisible){
                    LSizesLayout.setVisibility(View.GONE);
                    TileSelectorLayoutVisible = false;
                } else {
                    LSizesLayout.setVisibility(View.VISIBLE);
                    TileSelectorLayoutVisible = true;
                }
                break;
            }

            case R.id.b15x15: {
                TILE_SIZE = 15;
                bNewGame.setEnabled(true);
                bNewGame.setBackground(getResources().getDrawable(R.drawable.menu_new_game));
                LSizesLayout.setVisibility(View.GONE);
                TileSelectorLayoutVisible = false;
                break;
            }

            case R.id.b19x19: {
                TILE_SIZE = 19;
                bNewGame.setEnabled(true);
                bNewGame.setBackground(getResources().getDrawable(R.drawable.menu_new_game));
                LSizesLayout.setVisibility(View.GONE);
                TileSelectorLayoutVisible = false;
                break;
            }

            case R.id.b24x24: {
                TILE_SIZE = 24;
                bNewGame.setEnabled(true);
                bNewGame.setBackground(getResources().getDrawable(R.drawable.menu_new_game));
                LSizesLayout.setVisibility(View.GONE);
                TileSelectorLayoutVisible = false;
                break;
            }

            case R.id.bNewGame:{
                Intent myIntent = new Intent(MenuActivity.this, GameActivity.class);
                myIntent.putExtra("tiles", TILE_SIZE);
                startActivity(myIntent);
                break;
            }

            case R.id.bResumeGame:{
                Intent myIntent = new Intent(MenuActivity.this, GameActivity.class);
                myIntent.putExtra("tiles", TILE_SIZE);
                startActivity(myIntent);
                break;
            }

            case R.id.bExit:{
                finish();
                break;
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        bResumeGame.setVisibility(View.VISIBLE);
    }
}
