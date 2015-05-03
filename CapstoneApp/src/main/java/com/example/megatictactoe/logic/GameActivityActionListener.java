package com.example.megatictactoe.logic;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import com.example.megatictactoe.megatictactoe.R;
/**
 * modify by Yuan chen on 4/20/15.
 */
public class GameActivityActionListener implements View.OnLongClickListener
{
    private Context context;

    public GameActivityActionListener(int TABLE_SIZE, Context cont)
    {
        // Context for editing views on activity
        this.context = cont;

        // Set default wining condition as false
        GameManager.GAMEWIN = false;

        // Class object for handling game state checks
        GameManager.setBoardSize(TABLE_SIZE);
        GameManager.generateList();
    }

    @Override
    public boolean onLongClick(View v)
    {
        // Add a boolean to freeze the turn of button state when wining occur
        if(GameManager.GAMEWIN == false)
        {
            if (GameManager.checkIfEmpty(v, GameManager.TURN))
            {
                GameManager.GAMEWIN = GameManager.checkForWin(v);
                if (GameManager.GAMEWIN) {
                    displayWinDialog();
                }
                setButtonState(v);
            }
            return true;
        }
        return false;
    }

    private void displayWinDialog()
    {
        final Dialog dlg = new Dialog(context);
        dlg.setContentView(R.layout.win_dialog);
        dlg.setTitle(GameManager.TURN + " wins!");
        dlg.show();
    }

    // Set button drawable depending on who's move it is.
    // Mobile device vibrates on longClick to place marker.
    // Turn variable is flipped after marker placed.
    private void setButtonState(View iB)
    {
        switch (GameManager.TURN)
        {
            case 'X':
                iB.setBackground(context.getResources().getDrawable(R.drawable.cell_button_x));
                GameManager.TURN = 'O';
                break;
            case 'O':
                iB.setBackground(context.getResources().getDrawable(R.drawable.cell_button_o));
                GameManager.TURN = 'X';
                break;
            default:
                iB.setBackground(context.getResources().getDrawable(R.drawable.cell_default));
                break;
        }
    }
};