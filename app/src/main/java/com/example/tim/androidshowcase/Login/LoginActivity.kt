package com.example.tim.androidshowcase.Login

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.databinding.library.baseAdapters.BR
import com.example.tim.androidshowcase.MainActivity
import com.example.tim.androidshowcase.R
import com.example.tim.androidshowcase.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    companion object {
        private const val prefsFile = ".login_prefs"
        private const val pref_tag_latest_name = "LOGIN_NAME"
        private const val pref_tag_latest_pass = "LOGIN_PASS"
        private const val pref_tag_remember_me = "LOGIN_REMEMBER"
        const val TAG = "LoginActivity"
    }

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loadLoginDetails()

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.setVariable(BR.loginViewModel, loginViewModel)
        binding.executePendingBindings()

        loginViewModel.loginName.observe(this, android.arch.lifecycle.Observer {
            editTextLoginName.setText(it)
        })
        loginViewModel.loginPass.observe(this, android.arch.lifecycle.Observer {
            editTextLoginPass.setText(it)
        })
        loginViewModel.loginRemember.observe(this, android.arch.lifecycle.Observer {
            checkBoxLogin.isChecked = it!!
        })

        buttonLogin.setOnClickListener {
            loginViewModel.loginRemember.value = checkBoxLogin.isChecked
            loginViewModel.loginName.value = editTextLoginName.text.toString()
            loginViewModel.loginPass.value = editTextLoginPass.text.toString()
            Toast.makeText(this, "Logged in as " + loginViewModel.loginName.value, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onStop() {
        super.onStop()
        saveLoginDetails()
    }

    private fun loadLoginDetails() {
        val sharedPreferences = getSharedPreferences(prefsFile, Context.MODE_PRIVATE)
        loginViewModel.loginRemember.value = sharedPreferences.getBoolean(pref_tag_remember_me, false)

        if (loginViewModel.loginRemember.value!!) {
            loginViewModel.loginName.value = sharedPreferences.getString(pref_tag_latest_name, "")
            loginViewModel.loginPass.value = sharedPreferences.getString(pref_tag_latest_pass, "")
        }
    }

    private fun saveLoginDetails() {
        val editor = getSharedPreferences(prefsFile, Context.MODE_PRIVATE).edit()
        editor.putBoolean(pref_tag_remember_me, loginViewModel.loginRemember.value!!)
        if (loginViewModel.loginRemember.value!!) {
            editor.putString(pref_tag_latest_pass, loginViewModel.loginPass.value)
                    .putString(pref_tag_latest_name, loginViewModel.loginName.value)
        }
        editor.apply()
    }
}
