package com.kotlinhva.rock_paper_scissor

import android.os.Build
import java.time.Instant.now
import java.time.LocalDateTime
import java.util.*
import java.util.Calendar.getInstance

data class Game(val playerPlay: Play) {
    lateinit var computer: Play;
    var date: Calendar
    lateinit var winner: GameResult;

    // initializer block
    init {
        getComputerPlay()
        date = getInstance()
        setWinner()

    }

    private fun getComputerPlay() {
        computer = Play.values()[(0..2).random()];
    }

    private fun setWinner() {
        if (playerPlay == Play.ROCK) {
            if (computer == Play.SCISSORS) {
                winner = GameResult.Player
            } else if (computer == Play.ROCK) {
                winner = GameResult.Draw
            } else {
                winner = GameResult.Computer
            }
        }
        if (playerPlay == Play.SCISSORS) {
            if (computer == Play.SCISSORS) {
                winner = GameResult.Draw
            } else if (computer == Play.ROCK) {
                winner = GameResult.Computer
            } else {
                winner = GameResult.Player
            }
        }
        if (playerPlay == Play.PAPER) {
            if (computer == Play.SCISSORS) {
                winner = GameResult.Computer
            } else if (computer == Play.ROCK) {
                winner = GameResult.Player
            } else {
                winner = GameResult.Draw
            }
        } else {
            // you cheated! computer wins
            winner = GameResult.Computer
        }

    }

}