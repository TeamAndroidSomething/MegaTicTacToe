package com.example.megatictactoe.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import com.example.megatictactoe.logic.GameManager;
import com.example.megatictactoe.megatictactoe.R;

import java.util.ArrayList;

/**
 * modify by Yuan chen on 4/20/15.
 */
public class GameActivityActionListener implements View.OnLongClickListener
{
    private char TURN;
    private Context cont;
    private boolean gameWin;

    public GameActivityActionListener(int TABLE_SIZE, Context cont)
    {
        // Context for editing views on activity
        this.cont = cont;

        // Set default wining condition as false
        this.gameWin = false;

        // To apply vibrate feature to X,O selections
        final Vibrator vib = (Vibrator) cont.getSystemService(Context.VIBRATOR_SERVICE);

        // Class object for handling game state checks
        //this.gm = new GameManager(TABLE_SIZE);

        // Who's turn is it?  - defaults to X
        TURN = 'X';
    }

    @Override
    public boolean onLongClick(View v)
    {
        // Add a boolean to freeze the turn of button state when wining occur
        if(gameWin == false)
        {
            if (GameManager.checkIfEmpty(v, TURN))
            {
                gameWin = GameManager.checkForWin(v);
                setButtonState(v);
                if (gameWin) {
                    final Dialog dlg = new Dialog(cont);
                    dlg.setContentView(R.layout.win_dialog);
                    dlg.setTitle(GameManager.lastTurn + " wins!");
                    dlg.show();
                    GameManager.setHighlight(this.cont);
                }

            }
            return true;
        }
        return false;
    }

    // Set button drawable depending on who's move it is.
    // Mobile device vibrates on longClick to place marker.
    // Turn variable is flipped after marker placed.
    private void setButtonState(View iB)
    {
        switch (TURN)
        {
            case 'X':
                iB.setBackground(cont.getResources().getDrawable(R.drawable.cell_button_x));
                TURN = 'O';
                break;
            case 'O':
                iB.setBackground(cont.getResources().getDrawable(R.drawable.cell_button_o));
                TURN = 'X';
                break;
            default:
                iB.setBackground(cont.getResources().getDrawable(R.drawable.cell_default));
                break;
        }
    }
};