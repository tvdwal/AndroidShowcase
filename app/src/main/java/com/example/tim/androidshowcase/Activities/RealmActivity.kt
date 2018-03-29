package com.example.tim.androidshowcase.Activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tim.androidshowcase.R
import com.example.tim.androidshowcase.Realm.RealmViewModel

import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {

    lateinit var realmViewModel: RealmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        realmViewModel = ViewModelProviders.of(this).get(RealmViewModel::class.java)
        supportFragmentManager.beginTransaction()
                .add(R.id.layoutRealmFragmentContainer, realmViewModel.getLatestfragment(), realmViewModel.getLatestfragment().tag)
                .commit()
    }

}
