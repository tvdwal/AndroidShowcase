package com.example.tim.androidshowcase.Activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.tim.androidshowcase.R
import com.example.tim.androidshowcase.Realm.RealmNewItemFragment
import com.example.tim.androidshowcase.Realm.RealmOverviewFragment

import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)
        setSupportActionBar(toolbar)

        showFragment(RealmOverviewFragment())

        fab.setOnClickListener {
            val fragment = RealmNewItemFragment()
            showFragment(fragment)
            fab.setImageResource(fragment.getFabIcon())
        }
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.layoutRealmFragmentContainer, fragment)
                .addToBackStack("NewItem")
                .commit()
    }

}
