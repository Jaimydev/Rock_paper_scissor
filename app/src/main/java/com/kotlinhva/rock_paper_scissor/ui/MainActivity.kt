package com.kotlinhva.rock_paper_scissor.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlinhva.rock_paper_scissor.R
import com.kotlinhva.rock_paper_scissor.database.GameRepository
import com.kotlinhva.rock_paper_scissor.model.Game
import com.kotlinhva.rock_paper_scissor.model.GameResult
import com.kotlinhva.rock_paper_scissor.model.Play
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val SHOW_HISTORY_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {

    private lateinit var gameRepository: GameRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        gameRepository = GameRepository(this)
        initViews()

    }

    private fun initViews() {

        fab.setOnClickListener {
            startHistoryActivity()
        }
        paper.setOnClickListener { doGame(Play.PAPER) }
        scissor.setOnClickListener { doGame(Play.SCISSORS) }
        rock.setOnClickListener { doGame(Play.ROCK) }
    }

    private fun startHistoryActivity() {
        val intent = Intent(this, HistoryActivity::class.java)
        startActivityForResult(intent, SHOW_HISTORY_REQUEST_CODE)
    }

    private fun doGame(play: Play) {
        var game = Game(play);
        addGame(game)
        updateUI(game)

    }


    private fun addGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.insertGame(game)
            }
        }
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI(game: Game) {

        when (game.winner) {
            GameResult.Computer -> tvResult.text = "Computer wins!"
            GameResult.Player -> tvResult.text = "Player wins!"
            GameResult.Draw -> tvResult.text = "Draw"
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
