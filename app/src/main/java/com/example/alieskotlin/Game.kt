package com.example.alieskotlin


import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import com.example.alieskotlin.WordManagment.CardWordAdapter
import com.example.alieskotlin.WordManagment.Word
import com.example.alieskotlin.WordManagment.WordDiffCallback
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.ArrayList


class Game : Fragment(),  CardStackListener {

    private val cardStackView by lazy { view!!.findViewById<CardStackView>(R.id.card_word_view) }
    private val manager by lazy { CardStackLayoutManager(context, this) }
    private val adapter by lazy { CardWordAdapter(createWordsList()) }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)

    }

    override fun onStart() {
        super.onStart()
        setupCardWordView()

        countDownTimer.start()

        tv_endGame.setOnClickListener {
            countDownTimer.cancel()
            findNavController().navigate(R.id.action_game_to_teams)
        }

    }

    private var countDownTimer = object : CountDownTimer(60000, 1000) {


        override fun onFinish() {
            tv_timer.text = getString(R.string.time_over)
        }

        override fun onTick(millisUntilFinished: Long) {
            tv_timer.text = ("" + millisUntilFinished / 1000)
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

    override fun onCardDragging(direction: Direction, ratio: Float) {
        Log.d("CardStackView", "onCardDragging: d = ${direction.name}, r = $ratio")
    }

    override fun onCardSwiped(direction: Direction) {
        Log.d("CardStackView", "onCardSwiped: p = ${manager.topPosition}, d = $direction")
        if (manager.topPosition == adapter.itemCount - 5) {
            paginate()
        }
    }

    override fun onCardRewound() {
        Log.d("CardStackView", "onCardRewound: ${manager.topPosition}")
    }

    override fun onCardCanceled() {
        Log.d("CardStackView", "onCardCanceled: ${manager.topPosition}")
    }

    override fun onCardAppeared(view: View, position: Int) {
        val textView = view.findViewById<TextView>(R.id.item_name)
        Log.d("CardStackView", "onCardAppeared: ($position) ${textView.text}")
    }

    override fun onCardDisappeared(view: View, position: Int) {
        val textView = view.findViewById<TextView>(R.id.item_name)
        Log.d("CardStackView", "onCardDisappeared: ($position) ${textView.text}")
    }


    private fun setupCardWordView() {
        initialize()
    }

    private fun initialize() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.1f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
        cardStackView.itemAnimator.apply {

            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    private fun paginate() {
        val old = adapter.getWords()
        val new = old.plus(createWordsList())
        val callback = WordDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setWords(new)
        result.dispatchUpdatesTo(adapter)
    }

    private fun createWordsList(): List<Word> {
        val wordsArrayList = ArrayList<Word>()
        wordsArrayList.add(Word(name = "house"))
        wordsArrayList.add(Word(name = "hamster"))
        wordsArrayList.add(Word(name = "cow"))
        wordsArrayList.add(Word(name = "milk"))
        wordsArrayList.add(Word(name = "sky"))
        wordsArrayList.add(Word(name = "pen"))
        wordsArrayList.add(Word(name = "window"))
        wordsArrayList.add(Word(name = "song"))
        return wordsArrayList
    }

}
