package com.example.alieskotlin


import android.content.res.AssetManager
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_game_settings.*

class GameSettings : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_settings, container, false)
    }

    override fun onStart() {

        var selectedTime : String

        moveToWordListChoosing.setOnClickListener {
            findNavController().navigate(R.id.action_gameSettings_to_wordListChoosing)
        }

        val timeChoose = arrayOf("30 sec", "1 min", "2 min", "4 min")
        val arrayAdapter =
            context?.let { ArrayAdapter<String>(it, android.R.layout.simple_spinner_dropdown_item, timeChoose) }

        spinner_timeChoosing.adapter = arrayAdapter


        spinner_timeChoosing.onItemSelectedListener = object :

        AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            selectedTime = "1 min"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            selectedTime = timeChoose[position]
            }

        }

        super.onStart()
    }

}
