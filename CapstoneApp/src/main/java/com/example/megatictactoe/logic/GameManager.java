package com.example.megatictactoe.logic;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.megatictactoe.megatictactoe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by davidlescard on 3/30/15.
 */
public class GameManager {

    // Context to change and edit views
    Context mContext;

    // ArrayList View of the board
    public ArrayList<ArrayList<String>> boardlist = new ArrayList<ArrayList<String>>();

    public GameManager (int boardSize) {
        // creates the ArrayList of ArrayLists and fills it with empty strings
        for(int i = 0; i < boardSize; i++){
            ArrayList<String> row = new ArrayList<String>();
            for(int j = 0; j < boardSize; j++){
                row.add("");
            }
            boardlist.add(row);
        }
    };

    public void checkForWin(View iB) {
        // TODO: This
    }

    public boolean checkIfEmpty(View iB, char TURN) {
        // declares iB as an ImageButton (might be able to remove)
        ImageButton bb = (ImageButton) iB;

        // Gets the tag value minus the first char. Will error if Tag not set
        String tagNob =  bb.getTag().toString().substring(1);

        // splits the tag so we can get Row and Col values
        String[] SplitString = tagNob.split("_");

        // Setting row and col values as Integers
        int row = Integer.parseInt(SplitString[0]) - 1;
        int col = Integer.parseInt(SplitString[1]) - 1;

        // for debugging remove in final version
        Log.v("errorid","row: " + row);
        Log.v("errorid","col: " + col);

        // checks if spot available if
        if (boardlist.get(row).get(col) == ""){
            // make a copy of the row
            ArrayList<String> newRow = boardlist.get(row);

            // sets the row's col value to TURN
            newRow.set(col,Character.toString(TURN));

            //puts updates the row in boardlist
            boardlist.set(row,newRow);

            // for debugging, prints ArrayList<ArrayList<String>>
            Log.v("errorid",boardlist.toString());

            // returns that spot is available
            return true;


        }

        // spot not available since it didn't qualify the earlier check
        return false;
    }
}
