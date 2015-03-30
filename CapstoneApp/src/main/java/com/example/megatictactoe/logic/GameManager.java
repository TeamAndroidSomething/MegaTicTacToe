package com.example.megatictactoe.logic;

import android.content.Context;
import android.view.View;

import com.example.megatictactoe.megatictactoe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by davidlescard on 3/30/15.
 */
public class GameManager {

    Context mContext;

    public GameManager () {

    };

    public void checkForWin(View iB) {
//        mContext = context.getApplicationContext();

    }

    public boolean checkIfEmpty(View iB) {
//        mContext = context.getApplicationContext();
        if (iB.getBackground().equals(R.drawable.cell_button)) {
            return true;
        }
        return false;
    }

    public ArrayList<ArrayList<String>> list;
}
