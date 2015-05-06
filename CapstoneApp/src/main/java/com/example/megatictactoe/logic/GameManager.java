package com.example.megatictactoe.logic;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;

import com.example.megatictactoe.megatictactoe.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by davidlescard on 3/30/15.
 * modify by Yuan chen on 4/20/15.
 */
public class GameManager extends Application
{
    // Context to change and edit views
    Context mContext;

    // ArrayList View of the board
    private static ArrayList<ArrayList<String>> boardList = new ArrayList<ArrayList<String>>();

    public static String lastTurn = "error";
    private static int lastX = -1;
    private static int lastY = -1;

    private static Map<String, ImageButton> visualBoard;

    // keeps track of the pieces to highlight if game won
    static ArrayList<String> listUptoDown = new ArrayList<String>();
    static ArrayList<String> listLefttoRight = new ArrayList<String>();
    static ArrayList<String> listDownLefttoUpRight = new ArrayList<String>();
    static ArrayList<String> listUpLefttoDownRight = new ArrayList<String>();

    private static int boardSize = -1;


    public GameManager(){

    }

    public static void setHighlight(Context cont){
        ArrayList<String>  Highlight = new ArrayList<String>();
        String Cord1 = "00";
        Highlight.add(Cord1);

        Drawable backgroundRes;

        if (lastTurn.equals("X")){
            backgroundRes = cont.getResources().getDrawable(R.drawable.cell_x_win);
        } else if(lastTurn.equals("O")){
            backgroundRes = cont.getResources().getDrawable(R.drawable.cell_o_win);
        } else {
            backgroundRes = cont.getResources().getDrawable(R.drawable.cell_default);
        }

        // clears out the lists
        listUptoDown = new ArrayList<String>();
        listLefttoRight = new ArrayList<String>();
        listDownLefttoUpRight = new ArrayList<String>();
        listUpLefttoDownRight = new ArrayList<String>();

        //generates the lists and sizes
        int checkUptoDown = checkNextUp(lastX, lastY)
                + checkNextDown(lastX,lastY) + 1;
        int checkLefttoRight = checkNextLeft(lastX, lastY)
                + checkNextRight(lastX, lastY) + 1;
        int checkDownLefttoUpRight = checkNextDownLeft(lastX, lastY)
                + checkNextUpRight(lastX, lastY) + 1;
        int checkUpLefttoDownRight = checkNextUpLeft(lastX, lastY)
                + checkNextDownRight(lastX, lastY) + 1;


        // changes the pieces to be highlighted
        visualBoard.get("b" + (lastX + 1) + "_" + (lastY + 1)).setBackground(backgroundRes);
        if (checkUptoDown == 5){
            for(String buttonname : listUptoDown){
                if(visualBoard.containsKey(buttonname)){
                    visualBoard.get(buttonname).setBackground(backgroundRes);
                }
            }

        } if (checkLefttoRight == 5){
            for(String buttonname : listLefttoRight){
                if(visualBoard.containsKey(buttonname)){
                    visualBoard.get(buttonname).setBackground(backgroundRes);
                }
            }

        } if (checkDownLefttoUpRight == 5){
            for(String buttonname : listDownLefttoUpRight){
                if(visualBoard.containsKey(buttonname)){
                    visualBoard.get(buttonname).setBackground(backgroundRes);
                }
            }

        } if (checkUpLefttoDownRight == 5){
            for(String buttonname : listUpLefttoDownRight){
                if(visualBoard.containsKey(buttonname)){
                    visualBoard.get(buttonname).setBackground(backgroundRes);
                }
            }

        }
    }

    public static ArrayList<ArrayList<String>> getBoard(){
        return boardList;
    }

    public static int getBoardSize(){
        return boardSize;
    }

    public static void CreateBoard (int boardSize){
        boardList = new ArrayList<ArrayList<String>>();

        // creates the ArrayList of ArrayLists and fills it with empty strings
        for(int i = 0; i < boardSize; i++)
        {
            ArrayList<String> row = new ArrayList<String>();
            for(int j = 0; j < boardSize; j++)
            {
                row.add("");
            }
            boardList.add(row);
        }

        //logs the board size, used in looking for winning condition
        GameManager.boardSize = boardSize;
    }

    public static boolean checkForWin(View iB){
        int checkUptoDown = checkNextUp(lastX, lastY)
                + checkNextDown(lastX,lastY) + 1;
        int checkLefttoRight = checkNextLeft(lastX, lastY)
                + checkNextRight(lastX, lastY) + 1;
        int checkDownLefttoUpRight = checkNextDownLeft(lastX, lastY)
                + checkNextUpRight(lastX, lastY) + 1;
        int checkUpLefttoDownRight = checkNextUpLeft(lastX, lastY)
                + checkNextDownRight(lastX, lastY) + 1;

        // using lastX and lastY check if there is a win.
        Log.v("errorid","checking win for: (" + lastX + "," + lastY + ")");
        Log.v("errorid","Up,Down:"  + checkUptoDown + " Left,Right:" + checkLefttoRight
                + " DownLeft,UpRight:" + checkDownLefttoUpRight
                +  " UpLeft,DownRight:" + checkUpLefttoDownRight);

        if ( (checkUptoDown == 5) || (checkLefttoRight == 5) || (checkDownLefttoUpRight == 5)
                || (checkUpLefttoDownRight == 5) )
        {
            // check if board is entirely full and no one can move.
            Log.v("errorid","WIN");
            return true;
        }
        return false;
    }

    // these two check from down left to up right for a win
    private static int checkNextUpRight(int X, int Y){
        int NewX = X + 1;
        int NewY = Y + 1;

        // checks if the new spot is outside the board
        if((NewX < boardSize) & (NewY < boardSize)){
            if (boardList.get(NewX).get(NewY).equals(lastTurn))
            {
                listDownLefttoUpRight.add("b" + (NewX + 1) + "_" + (NewY + 1));
                return checkNextUpRight(NewX, NewY) + 1;
            }
        }
        return 0;
    }

    private static int checkNextDownLeft(int X, int Y){
        int NewX = X - 1;
        int NewY = Y - 1;

        // checks if the new spot is outside the board
        if((NewX < boardSize) & (NewY < boardSize) & (NewX >= 0) & (NewY >= 0))
        {
            if (boardList.get(NewX).get(NewY).equals(lastTurn))
            {
                listDownLefttoUpRight.add("b" + (NewX + 1) + "_" + (NewY + 1));
                return checkNextDownLeft(NewX, NewY) + 1;
            }
        }
        return 0;
    }

    // checks left to right
    private static int checkNextRight(int X, int Y){
        int NewX = X + 1;
        int NewY = Y;

        // checks if the new spot is outside the board
        if((NewX < boardSize) & (NewY < boardSize) & (NewX >= 0) & (NewY >= 0))
        {
            if (boardList.get(NewX).get(NewY).equals(lastTurn))
            {
                listLefttoRight.add("b" + (NewX + 1) + "_" + (NewY + 1));
                return checkNextRight(NewX, NewY) + 1;
            }
        }
        return 0;
    }

    private static int checkNextLeft(int X, int Y){
        int NewX = X - 1;
        int NewY = Y;

        // checks if the new spot is outside the board
        if((NewX < boardSize) & (NewY < boardSize) & (NewX >= 0) & (NewY >= 0))
        {
            if (boardList.get(NewX).get(NewY).equals(lastTurn))
            {
                listLefttoRight.add("b" + (NewX + 1) + "_" + (NewY + 1));
                return checkNextLeft(NewX, NewY) + 1;
            }
        }
        return 0;
    }

    // checks up left to down right
    private static int checkNextUpLeft(int X, int Y){
        int NewX = X + 1;
        int NewY = Y - 1;

        // checks if the new spot is outside the board
        if((NewX < boardSize) & (NewY < boardSize) & (NewX >= 0) & (NewY >= 0))
        {
            if (boardList.get(NewX).get(NewY).equals(lastTurn))
            {
                listUpLefttoDownRight.add("b" + (NewX + 1) + "_" + (NewY + 1));
                return checkNextUpLeft(NewX, NewY) + 1;
            }
        }
        return 0;
    }
    private static int checkNextDownRight(int X, int Y){
        int NewX = X - 1;
        int NewY = Y + 1;

        // checks if the new spot is outside the board
        if((NewX < boardSize) & (NewY < boardSize) & (NewX >= 0) & (NewY >= 0))
        {
            if (boardList.get(NewX).get(NewY).equals(lastTurn))
            {
                listUpLefttoDownRight.add("b" + (NewX + 1) + "_" + (NewY + 1));
                return checkNextDownRight(NewX, NewY) + 1;
            }
        }
        return 0;
    }


    //checks up and down
    private static int checkNextUp(int X, int Y){
        int NewX = X;
        int NewY = Y + 1;

        // checks if the new spot is outside the board
        if((NewX < boardSize) & (NewY < boardSize) & (NewX >= 0) & (NewY >= 0))
        {
            if (boardList.get(NewX).get(NewY).equals(lastTurn))
            {
                listUptoDown.add("b" + (NewX + 1) + "_" + (NewY + 1));
                return checkNextUp(NewX, NewY) + 1;
            }
        }
        return 0;
    }

    private static int checkNextDown(int X, int Y){
        int NewX = X;
        int NewY = Y - 1;

        // checks if the new spot is outside the board
        if((NewX < boardSize) & (NewY < boardSize) & (NewX >= 0) & (NewY >= 0))
        {
            if (boardList.get(NewX).get(NewY).equals(lastTurn))
            {
                listUptoDown.add("b" + (NewX + 1) + "_" + (NewY+ 1));
                return checkNextDown(NewX, NewY) + 1;
            }
        }
        return 0;
    }

    public static boolean checkIfEmpty(View iB, char TURN){
        // declares iB as an ImageButton (might be able to remove)
        ImageButton bb = (ImageButton) iB;

        // Gets the tag value minus the first char. Will error if Tag not set
        String tagNob =  bb.getTag().toString().substring(1);

        // splits the tag so we can get Row and Col values
        String[] SplitString = tagNob.split("_");

        // Setting row and col values as Integers
        int row = Integer.parseInt(SplitString[0]) - 1;
        int col = Integer.parseInt(SplitString[1]) - 1;

        // checks if spot available if
        if (boardList.get(row).get(col).equals(""))
        {
            // make a copy of the row
            ArrayList<String> newRow = boardList.get(row);

            // sets the row's col value to TURN
            newRow.set(col,Character.toString(TURN));

            //puts updates the row in boardList
            boardList.set(row,newRow);

            // for debugging, prints ArrayList<ArrayList<String>>
            // Log.v("errorid",boardList.toString());

            //sets lastX and lastY so we know the last move placed
            lastX = row;
            lastY = col;
            lastTurn = Character.toString(TURN);

            // returns that spot is available
            return true;
        }

        // spot not available since it didn't qualify the earlier check
        return false;
    }

    public static void storeBoard(Map<String, ImageButton> gameHast) {
        GameManager.visualBoard = gameHast;

    }
}
