package com.example.alieskotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alieskotlin.R
import kotlinx.android.synthetic.main.card_teams.view.*

class TeamsAdapter : RecyclerView.Adapter<TeamsViewHolder>() {

    private val listTeams = listOf("First Team", "Second Team", "AddTeam")

    override fun getItemCount(): Int = listTeams.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val teamNameField = layoutInflater.inflate(R.layout.card_teams, parent, false)

        return TeamsViewHolder(teamNameField)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {

        val listTeams = listTeams[position]
        holder.view.tv_teamName.text = listTeams

    }

}

class TeamsViewHolder(val view: View) : RecyclerView.ViewHolder(view)

