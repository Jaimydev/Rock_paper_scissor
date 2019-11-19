package com.kotlinhva.rock_paper_scissor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlinhva.rock_paper_scissor.R
import com.kotlinhva.rock_paper_scissor.model.Game
import com.kotlinhva.rock_paper_scissor.model.GameResult
import com.kotlinhva.rock_paper_scissor.model.Play
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        paper.setOnClickListener { doGame(Play.PAPER) }
        scissor.setOnClickListener { doGame(Play.SCISSORS) }
        rock.setOnClickListener { doGame(Play.ROCK) }
    }

    private fun doGame(play: Play) {
        var game = Game(play);
        updateUI(game)
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI(game: Game) {

        when (game.winner)
        {
            GameResult.Computer ->  tvResult.text = "Computer wins!"
            GameResult.Player ->  tvResult.text = "Player wins!"
            GameResult.Draw ->  tvResult.text = "Draw"
        }

        when (game.playerPlay) {
            Play.PAPER -> ivPlayer.setImageResource(R.drawable.paper)
            Play.SCISSORS -> ivPlayer.setImageResource(R.drawable.scissors)
            Play.ROCK -> ivPlayer.setImageResource(R.drawable.rock)
        }

        when (game.computer) {
            Play.PAPER -> ivComputer.setImageResource(R.drawable.paper)
            Play.SCISSORS -> ivComputer.setImageResource(R.drawable.scissors)
            Play.ROCK -> ivComputer.setImageResource(R.drawable.rock)
        }
    }

}
