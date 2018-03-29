package com.example.tim.androidshowcase.Fragments

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class FragmentHelper {

    companion object {
        fun replaceFragment(fragmentManager: FragmentManager, replacedContainer: Int, fragment: Fragment) {
            fragmentManager
                    .beginTransaction()
                    .replace(replacedContainer, fragment)
                    .addToBackStack(fragment.tag)
                    .commit()
        }
    }
}
