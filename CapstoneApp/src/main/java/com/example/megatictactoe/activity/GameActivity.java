package com.example.megatictactoe.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.os.Vibrator;

import com.example.megatictactoe.logic.GameManager;
import com.example.megatictactoe.megatictactoe.R;

import java.util.HashMap;
import java.util.Map;


public class GameActivity extends Activity {

    private int TABLE_SIZE;
    private char TURN;
    private GameManager gm;
    private Map<String, ImageButton> buttons;
    private Context context;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_dyn);

        // Class object for handling game state checks
        gm = new GameManager();


        final Vibrator vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);

        final TableLayout gameTable = (TableLayout) findViewById(R.id.gameTable);
        TABLE_SIZE = 15;
        TURN = 'X';

        View.OnLongClickListener buttonLongClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (gm.checkIfEmpty(v)) {
                    setButtonState(v, vib);
                    gm.checkForWin(v);
                };
                return true;
            }
        };

        // Map of game square buttons
        buttons = new HashMap<String, ImageButton>();

        // Create game grid
        for (int rowNum = 1; rowNum < TABLE_SIZE+1; rowNum++) {
            // create row and add to game Table in XML
            TableRow row = new TableRow(this);
            gameTable.addView(row);
            for (int colNum = 1; colNum < TABLE_SIZE+1; colNum++) {
                // add buttons to row
                buttons.put("b" + rowNum + "_" + colNum, new ImageButton(this));
                buttons.get("b" + rowNum + "_" + colNum)
                        .setBackground(getResources().getDrawable(R.drawable.cell_button));
                row.addView(buttons.get("b" + rowNum + "_" + colNum));
                buttons.get("b" + rowNum + "_" + colNum).setLongClickable(true);
                buttons.get("b" + rowNum + "_" + colNum)
                        .setOnLongClickListener(buttonLongClickListener);
            }
        }

        context = this.getApplicationContext();
    }

    private void setButtonState(View iB, Vibrator vib) {
        switch (TURN) {
            case 'X':
                iB.setBackground(getResources().getDrawable(R.drawable.cell_button_x));
                vib.vibrate(25);
                TURN = 'O';
                break;
            case 'O':
                iB.setBackground(getResources().getDrawable(R.drawable.cell_button_o));
                vib.vibrate(25);
                TURN = 'X';
                break;
            default:
                iB.setBackground(getResources().getDrawable(R.drawable.cell_default));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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
}
