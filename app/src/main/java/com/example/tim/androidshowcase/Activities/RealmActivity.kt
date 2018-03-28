package com.example.tim.androidshowcase.Activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.tim.androidshowcase.R
import com.example.tim.androidshowcase.Realm.RealmOverviewFragment

import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {

    lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        currentFragment = RealmOverviewFragment()
        showFragment(currentFragment)

    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.layoutRealmFragmentContainer, fragment)
                .addToBackStack("NewItem")
                .commit()
    }

}
