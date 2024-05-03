package com.example.mainactivity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnTicTac(view: View) {
        val btnSelected = view as Button
        var cellID = 0
        when (btnSelected.id) {
            R.id.btnTicTac1 -> cellID = 1
            R.id.btnTicTac2 -> cellID = 2
            R.id.btnTicTac3 -> cellID = 3
            R.id.btnTicTac4 -> cellID = 4
            R.id.btnTicTac5 -> cellID = 5
            R.id.btnTicTac6 -> cellID = 6
            R.id.btnTicTac7 -> cellID = 7
            R.id.btnTicTac8 -> cellID = 8
            R.id.btnTicTac9 -> cellID = 9
        }
        GameLogic(cellID, btnSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun GameLogic(cellId: Int, btnSelected: Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.GRAY)
            player1.add(cellId)
            activePlayer = 2
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellId)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
        findWinner()
    }

    fun findWinner() {
        var winner = -1
        // row 1
        if (player1.containsAll(listOf(1, 2, 3)) || player1.containsAll(listOf(4, 5, 6)) || player1.containsAll(listOf(7, 8, 9))
        ) {
            winner = 1
        } else if (player2.containsAll(listOf(1, 2, 3)) || player2.containsAll(listOf(4, 5, 6)) || player2.containsAll(listOf(7, 8, 9))
        ) {
            winner = 2
        }
        // col 1
        if (player1.containsAll(listOf(1, 4, 7)) || player1.containsAll(listOf(2, 5, 8)) || player1.containsAll(listOf(3, 6, 9))
        ) {
            winner = 1
        } else if (player2.containsAll(listOf(1, 4, 7)) || player2.containsAll(listOf(2, 5, 8)) || player2.containsAll(listOf(3, 6, 9))
        ) {
            winner = 2
        }
        // diagonals
        if (player1.containsAll(listOf(1, 5, 9)) || player1.containsAll(listOf(3, 5, 7))) {
            winner = 1
        } else if (player2.containsAll(listOf(1, 5, 9)) || player2.containsAll(listOf(3, 5, 7))) {
            winner = 2
        }

        if (winner != -1) {
            val winnerName = if (winner == 1) "Player 1 ( X )" else "Player 2 ( O )"
            val message = "$winnerName is the winner.\nWould you like to play again?"
            AlertDialog.Builder(this).apply {
                setTitle("Winner")
                setMessage(message)
                setPositiveButton("Yes") { _, _ ->
                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
                }
                setNegativeButton("No") { _, _ ->
                    // Add your desired action here
                }
                create().show()
            }
        }
    }
}
