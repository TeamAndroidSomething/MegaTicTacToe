package com.example.megatictactoe.activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.view.View;
import com.example.megatictactoe.logic.GameManager;
import com.example.megatictactoe.megatictactoe.R;
/**
 * modify by Yuan chen on 4/20/15.
 */
public class GameActivityActionListener implements View.OnLongClickListener
{
    private char TURN;
    private Context cont;
    private GameManager gm;
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
        this.gm = new GameManager(TABLE_SIZE);

        // Who's turn is it?  - defaults to X
        TURN = 'X';
    }

    @Override
    public boolean onLongClick(View v)
    {
        // Add a boolean to freeze the turn of button state when wining occur
        if(gameWin == false)
        {
            if (gm.checkIfEmpty(v, TURN))
            {
                gameWin = gm.checkForWin(v);
                if (gameWin) {
                    final Dialog dlg = new Dialog(cont);
                    dlg.setContentView(R.layout.win_dialog);
                    dlg.setTitle(TURN + " wins!");
                    dlg.show();
                }
                setButtonState(v);
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
                //iB.setEnabled(false);
                TURN = 'O';
                break;
            case 'O':
                iB.setBackground(cont.getResources().getDrawable(R.drawable.cell_button_o));
                TURN = 'X';
                //iB.setEnabled(false);
                break;
            default:
                iB.setBackground(cont.getResources().getDrawable(R.drawable.cell_default));
                break;
        }
    }
};