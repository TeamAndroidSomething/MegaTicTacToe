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
        // in case we need to add anything to the constructor
    };

    public void checkForWin(View iB) {

    }

    public boolean checkIfEmpty(View iB) {
    // some check hinging on properties of the button view
        return true;
    }

    public ArrayList<ArrayList<String>> boardlist;
}
