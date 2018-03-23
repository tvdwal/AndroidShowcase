package com.example.tim.androidshowcase.Activities

import android.app.FragmentManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.tim.androidshowcase.R
import com.example.tim.androidshowcase.Realm.RealmNewItemFragment

import kotlinx.android.synthetic.main.activity_realm.*
import kotlinx.android.synthetic.main.content_realm.*

class RealmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            showFragment(RealmNewItemFragment())
        }
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack("NewItem")
                .commit()
    }

}
