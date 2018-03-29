package com.example.tim.androidshowcase.Realm

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment

class RealmViewModel : ViewModel() {
    private var latestfragment: Fragment? = null

    init {
        latestfragment = RealmOverviewFragment()
    }

    fun getLatestfragment(): Fragment {
        return latestfragment ?: RealmOverviewFragment()
    }
}
