package com.example.tim.androidshowcase.Activities

import android.app.Activity
import android.os.Bundle
import android.view.View

import com.example.tim.androidshowcase.R
import kotlinx.android.synthetic.main.activity_viewmodel.*

/**
 * Created by tvandewal on 19-12-2017.
 */

open class ViewModelActivity : Activity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)
    }

    fun buttonPlusOneOnClick(view: View) {
        updateCounter(true, 1)
    }

    fun buttonPlusTwoOnClick(view: View) {
        updateCounter(true, 2)
    }

    fun buttonMinusOneOnClick(view: View) {
        updateCounter(false, 1)
    }

    fun buttonMinusTwoOnClick(view: View) {
        updateCounter(false, 2)
    }

    private fun updateCounter(increment: Boolean, value: Int) {
        if (increment) {
            counter += value
        } else {
            counter -= value
        }
        textViewCounter.setText(counter.toString())
    }
}
