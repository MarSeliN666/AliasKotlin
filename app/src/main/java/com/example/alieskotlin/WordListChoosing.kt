package com.example.alieskotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_word_list_choosing.*

class WordListChoosing : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word_list_choosing, container, false)
    }

    override fun onStart() {
        moveToGame.setOnClickListener{
            findNavController().navigate(R.id.action_wordListChoosing_to_game)
        }
        super.onStart()
    }


}
