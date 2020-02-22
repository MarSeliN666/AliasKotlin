package com.example.alieskotlin


import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_game.*


class Game : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onStart() {
        super.onStart()

        countDownTimer.start()

        tv_endGame.setOnClickListener {

            countDownTimer.cancel()

            findNavController().navigate(R.id.action_game_to_teams)

        }


    }

    var countDownTimer = object : CountDownTimer(6000, 1000) {
        override fun onFinish() {
            tv_timer.text = getString(R.string.time_over)
        }

        override fun onTick(millisUntilFinished: Long) {
            tv_timer.text = ("" + millisUntilFinished/1000)
        }

    }

    override fun onPause() {
        countDownTimer.cancel()

        super.onPause()
    }

    override fun onDestroy() {
        countDownTimer.cancel()

        super.onDestroy()
    }

}
