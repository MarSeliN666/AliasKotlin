package com.example.alieskotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_game_settings.*

var selectedTime: Long = 0
var wordsToWin: Long = 0

class GameSettings : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_settings, container, false)
    }



    override fun onStart() {


        moveToWordListChoosing.setOnClickListener {
            findNavController().navigate(R.id.action_gameSettings_to_wordListChoosing)
        }

        val timeChoose = arrayOf("30 sec", "1 min", "2 min", "4 min")
        val spinnerTimeArrayAdapter =
            context?.let { ArrayAdapter<String>(it, R.layout.spinner_text_dark, timeChoose) }

        spinnerTimeArrayAdapter?.setDropDownViewResource(R.layout.spinner_text_dark)
        spinner_timeChoosing.adapter = spinnerTimeArrayAdapter
        spinner_timeChoosing.setSelection(1)
        spinner_timeChoosing.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

                selectedTime = 60000
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when (position) {
                    0 -> selectedTime = 30000
                    1 -> selectedTime = 60000
                    2 -> selectedTime = 120000
                    3 -> selectedTime = 240000
                }
            }

        }

        val wordsToWinChoose = arrayOf("30 words", "60 words", "80 words", "100 words")
        val spinnerWordsArrayAdapter =
            context?.let { ArrayAdapter<String>(it, R.layout.spinner_text_dark, wordsToWinChoose) }

        spinnerWordsArrayAdapter?.setDropDownViewResource(R.layout.spinner_text_dark)
        spinner_wordsNumberChoosing.adapter = spinnerWordsArrayAdapter
        spinner_wordsNumberChoosing.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                wordsToWin = 30
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when (position) {
                    0 -> wordsToWin = 30
                    1 -> wordsToWin = 60
                    2 -> wordsToWin = 80
                    3 -> wordsToWin = 100
                }
            }

        }

        super.onStart()
    }

}
