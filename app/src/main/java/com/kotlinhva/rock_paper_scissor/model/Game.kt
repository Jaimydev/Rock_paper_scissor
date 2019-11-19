package com.kotlinhva.rock_paper_scissor.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*
import java.util.Calendar.getInstance

@Parcelize
@Entity(tableName = "game_table")
data class Game(

    val playerPlay: Play? = null,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null,

    var date: Date? = null,
    var winner: GameResult? = null,
    var computer: Play?= null

) : Parcelable
{
    // initializer block
    init {
        if(playerPlay == null)
            throw KotlinNullPointerException()

        getComputerPlay()
        date = Date()
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
                null -> TODO()
            }
            Play.SCISSORS -> winner = when (computer) {
                Play.SCISSORS -> GameResult.Draw
                Play.ROCK -> GameResult.Computer
                Play.PAPER -> GameResult.Player
                null -> TODO()
            }
            Play.PAPER -> winner = when (computer) {
                Play.SCISSORS -> GameResult.Computer
                Play.ROCK -> GameResult.Player
                Play.PAPER -> GameResult.Draw
                null -> TODO()
            }
            else -> // you cheated! computer wins
                winner = GameResult.Computer
        }

    }

}