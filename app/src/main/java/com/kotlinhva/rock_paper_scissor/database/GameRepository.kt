package com.kotlinhva.rock_paper_scissor.database

import android.content.Context
import com.kotlinhva.rock_paper_scissor.model.Game

class GameRepository(context: Context) {


    private val gameDao: GameDao

    init {
        val database =
            RockPaperScissorRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    suspend fun getAllGames(): List<Game> = gameDao.getAllGames()

    suspend fun insertGame(game: Game) = gameDao.insertGame(game)

    suspend fun deleteGame(game: Game) = gameDao.deleteGame(game)

    suspend fun deleteAllGames() = gameDao.deleteAllGames()


}