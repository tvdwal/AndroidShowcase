package com.example.tim.androidshowcase

import android.app.Activity
import android.view.inputmethod.InputMethodManager

class Utils {
    companion object {
        fun closeKeyboard(activity: Activity) {
            val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            val v = activity.currentFocus
            if (v != null) {
                inputMethodManager.hideSoftInputFromWindow(v.windowToken, 0)
            }
        }
    }
}