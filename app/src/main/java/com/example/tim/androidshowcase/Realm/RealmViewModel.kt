package com.example.tim.androidshowcase.Realm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import java.util.*

class RealmViewModel : ViewModel() {
    private var latestfragment: Fragment? = null
    private var personsData: MutableLiveData<ArrayList<Person>> = MutableLiveData()
    var selectedIndex = 0

    init {
        latestfragment = RealmOverviewFragment()
        populate()
    }

    private fun populate() {
        var persons = ArrayList<Person>()
        var p = Person("Tim", 25, "CEO");
        p.setImportance(true)
        persons.add(p)
        persons.add((Person("Tim2", 22, "CFO")))
        persons.add((Person("Tim3", 23, "CIO")))
        persons.add((Person("Tim4", 24, "COO")))
        persons.add(p)
        persons.add((Person("Tim2", 22, "CFO")))
        persons.add((Person("Tim3", 23, "CIO")))
        persons.add((Person("Tim4", 24, "COO")))
        var seed = System.nanoTime()
        persons.shuffle(Random(seed))
        personsData.value = persons
    }

    fun setLatestFragment(fragment: Fragment) {
        latestfragment = fragment
    }

    fun getLatestfragment(): Fragment {
        return latestfragment ?: RealmOverviewFragment()
    }

    fun addPerson(p: Person) {
        personsData.value!!.add(p)
    }

    fun getPersonList(): MutableLiveData<ArrayList<Person>> {
        return personsData
    }

    fun getSelectedPerson(): Person {
        return personsData.value!![selectedIndex]
    }
}
