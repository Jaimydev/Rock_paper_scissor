package com.kotlinhva.rock_paper_scissor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

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


    }


}
