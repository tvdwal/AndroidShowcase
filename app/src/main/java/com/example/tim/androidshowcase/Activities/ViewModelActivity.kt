package com.example.tim.androidshowcase.Activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.tim.androidshowcase.MyViewModel

import com.example.tim.androidshowcase.R
import kotlinx.android.synthetic.main.activity_viewmodel.*

/**
 * Created by tvandewal on 19-12-2017.
 */

open class ViewModelActivity : FragmentsActivity() {

    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)

        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        textViewCounter.setText(viewModel.getScore().toString())

        initButtons()
    }

    fun initButtons() {
        buttonPlusOne.setOnClickListener {
            viewModel.increaseScore(1)
            textViewCounter.setText(viewModel.getScore().toString())
        }
        buttonPlusTwo.setOnClickListener {
            viewModel.increaseScore(2)
            textViewCounter.setText(viewModel.getScore().toString())
        }
        buttonMinusOne.setOnClickListener {
            viewModel.decreaseScore(1)
            textViewCounter.setText(viewModel.getScore().toString())
        }
        buttonMinusTwo.setOnClickListener {
            viewModel.decreaseScore(2)
            textViewCounter.setText(viewModel.getScore().toString())
        }
    }
}
