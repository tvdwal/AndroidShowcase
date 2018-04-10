package com.example.tim.androidshowcase.Realm

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment

class RealmViewModel : ViewModel() {
    private var latestfragment: Fragment? = null
    private var persons: ArrayList<Person> = ArrayList()
    var selectedIndex = 0

    init {
        latestfragment = RealmOverviewFragment()

    }

    fun setLatestFragment(fragment: Fragment) {
        latestfragment = fragment
    }

    fun getLatestfragment(): Fragment {
        return latestfragment ?: RealmOverviewFragment()
    }

    fun addPerson(p: Person) {
        persons.add(p)
    }

    fun getPersonList(): ArrayList<Person> {
        return persons
    }

    fun getSelectedPerson(): Person {
        return persons[selectedIndex]
    }
}
