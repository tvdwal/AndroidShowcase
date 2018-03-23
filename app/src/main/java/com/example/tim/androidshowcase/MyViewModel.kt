package com.example.tim.androidshowcase

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel

/**
 * Created by Tim on 22-3-2018.
 */

class MyViewModel : ViewModel() {
    private var score = 0

    fun getScore() : Int {
        return score
    }

    fun resetScore() {
        score = 0
    }

    fun increaseScore(amount: Int) {
        score += amount
    }

    fun decreaseScore(amount: Int) {
        score -= amount
    }

}
