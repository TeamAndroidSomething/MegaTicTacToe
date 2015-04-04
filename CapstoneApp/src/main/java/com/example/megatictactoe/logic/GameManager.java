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

    Context mContext;
    public ArrayList<ArrayList<String>> boardlist = new ArrayList<ArrayList<String>>();
    int boardSize;

    public GameManager (int boardSize) {
        // in case we need to add anything to the constructor
        this.boardSize = boardSize;

        for(int i = 0; i < boardSize; i++){
            ArrayList<String> row = new ArrayList<String>();
            for(int j = 0; j < boardSize; j++){
                row.add("");
            }
            boardlist.add(row);
        }
    };

    public void checkForWin(View iB) {

    }

    public boolean checkIfEmpty(View iB) {
    // some check hinging on properties of the button view
        ImageButton bb = (ImageButton) iB;
        String tagNob =  bb.getTag().toString().substring(1);
        String[] SplitString = tagNob.split("_");
        int row = Integer.parseInt(SplitString[0]);
        int col = Integer.parseInt(SplitString[1]);

        Log.v("errorid","row: " + row);
        Log.v("errorid","col: " + col);

        return true;
    }
}
