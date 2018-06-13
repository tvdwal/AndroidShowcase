package com.example.tim.androidshowcase.Login

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.android.databinding.library.baseAdapters.BR
import com.example.tim.androidshowcase.MainActivity
import com.example.tim.androidshowcase.R
import com.example.tim.androidshowcase.databinding.FragmentLoginLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login_login.*

class LoginFragment : Fragment() {

    companion object {
        private const val prefsFile = ".login_prefs"
        private const val pref_tag_latest_name = "LOGIN_NAME"
        private const val pref_tag_latest_pass = "LOGIN_PASS"
        private const val pref_tag_remember_me = "LOGIN_REMEMBER"
        const val tag: String = "LoginFragment"
    }

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseAuthListener: FirebaseAuth.AuthStateListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        loginViewModel = ViewModelProviders.of(activity).get(LoginViewModel::class.java)

        val binding: FragmentLoginLoginBinding = DataBindingUtil.inflate(inflater!!, R.layout.fragment_login_login, container, false)
        val rootView: View = binding.root
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

        loadLoginDetails()

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser

        }

        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        buttonLogin.setOnClickListener {
            loginViewModel.loginRemember.value = checkBoxLogin.isChecked
            loginViewModel.loginName.value = editTextLoginName.text.toString()
            loginViewModel.loginPass.value = editTextLoginPass.text.toString()
            loginAs(loginViewModel.loginName.value!!, loginViewModel.loginPass.value!!)
        }
        buttonSignUp.setOnClickListener {
            loginViewModel.loginName.value = editTextLoginName.text.toString()
            activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.layoutLoginFragmentContainer, SignUpFragment(), SignUpFragment.tag)
                    .addToBackStack(null)
                    .commit()
        }
    }

    override fun onDestroy() {
        saveLoginDetails()
        super.onDestroy()
    }

    private fun loginAs(name: String, pass: String) {
        if (name.isEmpty() || pass.isEmpty()) {
            return
        }
        firebaseAuth.signInWithEmailAndPassword(name, pass).addOnCompleteListener(context as Activity, {
            task -> run {
            if (task.isSuccessful) {
                startActivity(Intent(context, MainActivity::class.java))
            } else {
                startActivity(Intent(context, MainActivity::class.java))
                Toast.makeText(this.activity, "Could not login as " + loginViewModel.loginName.value, Toast.LENGTH_SHORT).show()
            }
        }
        })
    }

    private fun loadLoginDetails() {
        val sharedPreferences = this.activity.getSharedPreferences(prefsFile, Context.MODE_PRIVATE)
        loginViewModel.loginRemember.value = sharedPreferences.getBoolean(pref_tag_remember_me, false)

        if (loginViewModel.loginRemember.value!!) {
            loginViewModel.loginName.value = sharedPreferences.getString(pref_tag_latest_name, "")
            loginViewModel.loginPass.value = sharedPreferences.getString(pref_tag_latest_pass, "")
        }
    }

    private fun saveLoginDetails() {
        val editor = this.activity.getSharedPreferences(prefsFile, Context.MODE_PRIVATE).edit()
        editor.putBoolean(pref_tag_remember_me, loginViewModel.loginRemember.value!!)
        if (loginViewModel.loginRemember.value!!) {
            editor.putString(pref_tag_latest_pass, loginViewModel.loginPass.value)
                    .putString(pref_tag_latest_name, loginViewModel.loginName.value)
        }
        editor.apply()
    }
}
