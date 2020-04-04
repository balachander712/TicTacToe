package com.balachander.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View)
    {
        val buttonSelected = view as Button

        var cellID = 0

        when(buttonSelected.id)
        {
            R.id.b1 -> cellID = 1
            R.id.b2 -> cellID = 2
            R.id.b3 -> cellID = 3
            R.id.b4 -> cellID = 4
            R.id.b5 -> cellID = 5
            R.id.b6 -> cellID = 6
            R.id.b7 -> cellID = 7
            R.id.b8 -> cellID = 8
            R.id.b9 -> cellID = 9

        }

        playGame(cellID,buttonSelected)
        //Log.d("ButtonClick ", buttonSelected.id.toString())
        //Log.d("ButtonClick CellID ",cellID.toString())
    }


    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellID: Int , buttonSelected:Button)
    {
        if(activePlayer == 1)
        {
            buttonSelected.text = "X"
            buttonSelected.setBackgroundResource(R.color.lightblue)
            player1.add(cellID)
            activePlayer = 2
        }
        else if(activePlayer == 2)
        {
            buttonSelected.text = "O"
            buttonSelected.setBackgroundResource(R.color.green)
            player2.add(cellID)
            activePlayer = 1
        }

        buttonSelected.isEnabled = false

        checkWinner()
    }


    fun checkWinner()
    {
        var winner = -1


        //row 1

        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
        winner = 2
        }

        //row 2


        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //row 3


        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(8) && player2.contains(7) && player2.contains(9)){
            winner = 2
        }


        //col 1

        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }


        //col 2

        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }


        //col 3

        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }



        if(winner == 1)
        {
            Toast.makeText(this, "Player 1 Won ",Toast.LENGTH_LONG).show()
        }
        else if(winner == 2)
        {
            Toast.makeText(this,"Player 2 Won",Toast.LENGTH_LONG).show()
        }


    }



}

