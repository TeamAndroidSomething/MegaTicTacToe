package com.example.megatictactoe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.megatictactoe.logic.GameManager;
import com.example.megatictactoe.megatictactoe.R;


public class GameActivity extends Activity {

    private int TABLE_SIZE;
    private Map<String, ImageButton> buttons;
    private View.OnLongClickListener buttonLongClickListener;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TABLE_SIZE = GameManager.getBoardSize();

        // Master table in game layout
        final TableLayout gameTable = (TableLayout) findViewById(R.id.gameTable);

        // Map of game square buttons
        buttons = new HashMap<String, ImageButton>();

        //OnClickListener
        buttonLongClickListener = new GameActivityActionListener(TABLE_SIZE,this);


        // New Create game grid

        ArrayList<ArrayList<String>> board = GameManager.getBoard();
        Log.v("errorid", board.toString());

        for (int rowNum = 1; rowNum < TABLE_SIZE + 1; rowNum++) {
            // create row and add to game Table in XML
            TableRow row = new TableRow(this);
            gameTable.addView(row);
            // Add buttons to the new row
            for (int colNum = 1; colNum < TABLE_SIZE+1; colNum++) {
                //button name
                String bName = "b" + rowNum + "_" + colNum;

                // Temp button created for each button
                ImageButton bTemp = new ImageButton(this);

                // provide button with map key i.e. "b1_15" for row 1, column 15
                buttons.put(bName, bTemp);

                // set button background to drawable
                if (board.get(rowNum-1).get(colNum-1).equals("")){
                    bTemp.setBackground(getResources().getDrawable(R.drawable.cell_button));
                } else if(board.get(rowNum-1).get(colNum-1).equals("X")) {
                    bTemp.setBackground(getResources().getDrawable(R.drawable.cell_x_up));
                }else if(board.get(rowNum-1).get(colNum-1).equals("O")) {
                    bTemp.setBackground(getResources().getDrawable(R.drawable.cell_o_up));
                }



                // Add to button to row, via key
                row.addView(buttons.get(bName));

                // Add longClick action to button, via key
                bTemp.setLongClickable(true);
                bTemp.setTag(bName);
                bTemp.setOnLongClickListener(buttonLongClickListener);


            }
        }
        GameManager.storeBoard(buttons);
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
