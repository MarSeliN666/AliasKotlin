package com.example.alieskotlin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alieskotlin.adapters.TeamsAdapter
import kotlinx.android.synthetic.main.fragment_teams.*

class Teams : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onStart() {
        tv_endGame.setOnClickListener {
            findNavController().navigate(R.id.action_teams_to_gameSettings)
        }

        recyclerView_teams.layoutManager = LinearLayoutManager(context)
        recyclerView_teams.adapter =
            TeamsAdapter()

        super.onStart()
    }

}
