package com.example.tim.androidshowcase.Realm

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tim.androidshowcase.R

class RealmActivity : AppCompatActivity() {

    companion object {
        val TAG = "RealmActivity"
    }

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
