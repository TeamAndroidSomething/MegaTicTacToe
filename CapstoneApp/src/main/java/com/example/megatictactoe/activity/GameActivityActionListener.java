package com.example.megatictactoe.activity;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import com.example.megatictactoe.logic.GameManager;
import com.example.megatictactoe.megatictactoe.R;

public class GameActivityActionListener implements View.OnLongClickListener
{
    private char TURN;
    private Context cont;
    private GameManager gm;

    public GameActivityActionListener(int TABLE_SIZE, Context cont) {
        // Context for editing views on activity
        this.cont = cont;

        // To apply vibrate feature to X,O selections
        final Vibrator vib = (Vibrator) cont.getSystemService(Context.VIBRATOR_SERVICE);

        // Class object for handling game state checks
        this.gm = new GameManager(TABLE_SIZE);

        // Who's turn is it?  - defaults to X
        TURN = 'X';
    }

    @Override
    public boolean onLongClick(View v) {
        if (gm.checkIfEmpty(v, TURN)) {
            boolean isWin = gm.checkForWin(v);
            setButtonState(v);
        }
        return true;
    }

    // Set button drawable depending on who's move it is.
    // Mobile device vibrates on longClick to place marker.
    // Turn variable is flipped after marker placed.
    private void setButtonState(View iB) {
        switch (TURN) {
            case 'X':
                iB.setBackground(cont.getResources().getDrawable(R.drawable.cell_button_x));
                iB.setEnabled(false);
                TURN = 'O';
                break;
            case 'O':
                iB.setBackground(cont.getResources().getDrawable(R.drawable.cell_button_o));
                TURN = 'X';
                iB.setEnabled(false);
                break;
            default:
                iB.setBackground(cont.getResources().getDrawable(R.drawable.cell_default));
                break;
        }
    }
};