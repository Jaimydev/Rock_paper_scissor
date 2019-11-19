package com.kotlinhva.rock_paper_scissor.model

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
        when (playerPlay) {
            Play.ROCK -> winner = when (computer) {
                Play.SCISSORS -> GameResult.Player
                Play.ROCK -> GameResult.Draw
                Play.PAPER -> GameResult.Computer
            }
            Play.SCISSORS -> winner = when (computer) {
                Play.SCISSORS -> GameResult.Draw
                Play.ROCK -> GameResult.Computer
                Play.PAPER -> GameResult.Player
            }
            Play.PAPER -> winner = when (computer) {
                Play.SCISSORS -> GameResult.Computer
                Play.ROCK -> GameResult.Player
                Play.PAPER -> GameResult.Draw
            }
            else -> // you cheated! computer wins
                winner = GameResult.Computer
        }

    }

}