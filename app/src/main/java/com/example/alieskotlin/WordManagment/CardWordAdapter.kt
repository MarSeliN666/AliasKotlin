package com.example.alieskotlin.WordManagment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.alieskotlin.R


class CardWordAdapter(
        private var wordsList: List<Word> = emptyList()
) : RecyclerView.Adapter<CardWordAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_spot, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = wordsList[position]
        holder.name.text = "${word.name}"

        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, word.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return wordsList.size
    }

    fun setWords(words: List<Word>) {
        this.wordsList = words
    }

    fun getWords(): List<Word> {
        return wordsList
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_name)

    }

}
