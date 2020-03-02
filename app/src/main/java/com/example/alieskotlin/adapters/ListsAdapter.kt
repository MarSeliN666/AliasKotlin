package com.example.alieskotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alieskotlin.R
import kotlinx.android.synthetic.main.card_lists.view.*

class ListsAdapter : RecyclerView.Adapter<WordListsViewHolder>() {

    private val listTitles = listOf("Simple Words", "Harder Words", "Impossible Words")

    override fun getItemCount(): Int = listTitles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val wordListField = layoutInflater.inflate(R.layout.card_lists, parent, false)

        return WordListsViewHolder(wordListField)
    }

    override fun onBindViewHolder(holder: WordListsViewHolder, position: Int) {

        val listTitles = listTitles[position]
        holder.view.tv_listName.text = listTitles


    }
}


class WordListsViewHolder(val view: View) : RecyclerView.ViewHolder(view)