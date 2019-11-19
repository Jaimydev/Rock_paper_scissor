package com.kotlinhva.rock_paper_scissor.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinhva.rock_paper_scissor.R
import com.kotlinhva.rock_paper_scissor.model.Game
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.DateFormat


class GameAdapter(private val Games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int = Games.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(Games[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            itemView.tvWinner.text = "${game.winner}"
            itemView.tvDate.text = DateFormat.getDateTimeInstance().format(game.date)
        }
    }
}