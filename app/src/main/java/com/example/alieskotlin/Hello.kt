package com.example.alieskotlin


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_hello.*

class Hello : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onStart() {

        btnStartGame.setOnClickListener {
            findNavController().navigate(R.id.action_hello_to_teams)
        }
        tvInfo.setOnClickListener {
            dialogBuilder()

        }
        super.onStart()
    }

    private fun dialogBuilder() {
        val dialogBuilder = AlertDialog.Builder(activity!!, R.style.AlertDialogCustom)
        dialogBuilder
            .setMessage(R.string.info_app)
            .setPositiveButton("Cancel") { dialog, _ -> //not negative developer
                dialog.dismiss()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Info")
        alert.show()
    }

}
