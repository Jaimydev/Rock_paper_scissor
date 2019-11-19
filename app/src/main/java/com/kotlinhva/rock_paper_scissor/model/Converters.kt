package com.kotlinhva.rock_paper_scissor.model

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun playToString(play: Play): String = play.name

    @TypeConverter
    fun sToPlay(s: String): Play = Play.valueOf(s)

    @TypeConverter
    fun gameResultToString(gameResult: GameResult): String = gameResult.name

    @TypeConverter
    fun sToGameResult(s: String): GameResult = GameResult.valueOf(s)

}