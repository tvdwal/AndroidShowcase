package com.example.tim.androidshowcase.Login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tim.androidshowcase.R

class LoginActivity : AppCompatActivity() {

    companion object {
        const val TAG = "LoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction()
                .add(R.id.layoutLoginFragmentContainer, LoginFragment(), LoginFragment.tag)
                .commit()
    }
}
