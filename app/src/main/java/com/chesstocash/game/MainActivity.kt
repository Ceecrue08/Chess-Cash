
package com.chesstocash.game

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(20, 24, 20, 24)
            setBackgroundColor(Color.rgb(20, 25, 35))
        }

        val title = TextView(this).apply {
            text = "CHESS-TO-CASH"
            textSize = 28f
            gravity = Gravity.CENTER
            setTextColor(Color.rgb(230, 190, 110))
        }
        root.addView(title)

        val subtitle = TextView(this).apply {
            text = "THINK  •  PLAY  •  WIN"
            textSize = 13f
            gravity = Gravity.CENTER
            setTextColor(Color.LTGRAY)
            setPadding(0, 8, 0, 24)
        }
        root.addView(subtitle)

        val board = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val pieces = arrayOf(
            "♜♞♝♛♚♝♞♜",
            "♟♟♟♟♟♟♟♟",
            "........",
            "........",
            "........",
            "........",
            "♙♙♙♙♙♙♙♙",
            "♖♘♗♕♔♗♘♖"
        )

        for (r in 0..7) {
            val rank = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
            }

            for (c in 0..7) {
                val square = TextView(this).apply {
                    text = if (pieces[r][c] == '.') "" else pieces[r][c].toString()
                    textSize = 27f
                    gravity = Gravity.CENTER
                    setTextColor(if (r < 2) Color.BLACK else Color.WHITE)
                    setBackgroundColor(
                        if ((r + c) % 2 == 0)
                            Color.rgb(238, 216, 181)
                        else
                            Color.rgb(120, 82, 58)
                    )
                }

                rank.addView(
                    square,
                    LinearLayout.LayoutParams(0, 42, 1f)
                )
            }

            board.addView(rank)
        }

        root.addView(board)

        val coins = TextView(this).apply {
            text = "♛   CHESS COINS: 0"
            textSize = 19f
            gravity = Gravity.CENTER
            setTextColor(Color.rgb(230, 190, 110))
            setPadding(0, 24, 0, 20)
        }
        root.addView(coins)

        setContentView(root)
    }
}
