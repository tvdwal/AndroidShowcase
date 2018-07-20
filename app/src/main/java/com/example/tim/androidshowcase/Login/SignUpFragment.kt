package com.example.tim.androidshowcase.Login


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.android.databinding.library.baseAdapters.BR

import com.example.tim.androidshowcase.R
import com.example.tim.androidshowcase.Utils
import com.example.tim.androidshowcase.databinding.FragmentLoginSignUpBinding
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.fragment_login_sign_up.*

class SignUpFragment : Fragment(), TextWatcher {

    companion object {
        const val tag: String = "LoginFragment"
    }

    lateinit var loginViewModel: LoginViewModel
    lateinit var progressBar: ProgressBar
    lateinit var buttonSignUpFinish: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        loginViewModel = ViewModelProviders.of(activity).get(LoginViewModel::class.java)

        val binding: FragmentLoginSignUpBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_sign_up, container, false)
        val rootView = binding.root
        binding.setVariable(BR.loginViewModel, loginViewModel)
        binding.executePendingBindings()

        loginViewModel.loginName.observe(this, Observer {
            editTextLoginName.setText(loginViewModel.loginName.value)
        })

        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiateSignUpFlow(view!!)
    }

    private fun initiateSignUpFlow(rootView: View) {
        val animation: Animation = AlphaAnimation(0f, 1f)
        animation.interpolator = DecelerateInterpolator()
        animation.duration = 2000

        layoutSignUpPassword.visibility = View.GONE
        layoutSignUpPasswordConfirm.visibility = View.GONE
        layoutSignUpFinish.visibility = View.GONE

        progressBar = rootView.findViewById(R.id.progressBarSignUp)

        val buttonSignUp: Button = rootView.findViewById(R.id.buttonSignUpEmail)
        buttonSignUp.setOnClickListener {
            if (animation.hasEnded()) {
                loginViewModel.loginName.value = rootView.findViewById<EditText>(R.id.editTextLoginName).text.toString()
                layoutSignUpPassword.visibility = View.VISIBLE
                layoutSignUpPassword.startAnimation(animation)
            }
        }
        val buttonPassword: Button = rootView.findViewById(R.id.buttonSignUpPassword)
        buttonPassword.setOnClickListener {
            if (animation.hasEnded()) {
                layoutSignUpPasswordConfirm.visibility = View.VISIBLE
                layoutSignUpPasswordConfirm.startAnimation(animation)
            }
        }
        val buttonPasswordConfirm: Button = rootView.findViewById(R.id.buttonSignUpPasswordConfirm)
        buttonPasswordConfirm.setOnClickListener {
            if (animation.hasEnded()) {
                Utils.closeKeyboard(activity)
                layoutSignUpFinish.visibility = View.VISIBLE
                layoutSignUpFinish.startAnimation(animation)
            }
        }

        buttonSignUpFinish = rootView.findViewById(R.id.buttonSignUp)
        buttonSignUpFinish.setOnClickListener {
            if (comparePasswords() and validateEmail(loginViewModel.loginName.value!!)) {
                loginViewModel.loginPass.value = rootView.findViewById<EditText>(R.id.editTextLoginPass).text.toString()
                registerUser(loginViewModel.loginName.value!!, loginViewModel.loginPass.value!!)
            }
        }

        editTextLoginPass.addTextChangedListener(this)
        editTextLoginPassConfirm.addTextChangedListener(this)

        layoutSignUpEmail.startAnimation(animation)
    }

    override fun afterTextChanged(p0: Editable?) {
        comparePasswords()
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // not used
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // not used
    }

    private fun comparePasswords(): Boolean {
        val s1 = editTextLoginPass.text.toString()
        val s2 = editTextLoginPassConfirm.text.toString()
        if (s1 == "" && s2 == "") {
            textViewPasswordCheck.text = getString(R.string.passwords_empty)
            return false
        }
        return if (s1 == s2) {
            textViewPasswordCheck.text = getString(R.string.passwords_match)
            true
        } else {
            textViewPasswordCheck.text = getString(R.string.passwords_dont_match)
            false
        }
    }

    private fun validateEmail(email: String): Boolean {
        return Regex("\\w+((-\\w+)|(\\.\\w+))*\\@\\w+((\\.|-)\\w+)*\\.\\w+").matches(email)
    }

    private fun registerUser(username: String, password: String) {
        progressBar.visibility = View.VISIBLE
        buttonSignUpFinish.visibility = View.GONE
        loginViewModel.firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(activity) { task ->
            Toast.makeText(activity, "Registration: " + task.isSuccessful, Toast.LENGTH_SHORT).show()

            if (!task.isSuccessful) {
                progressBar.visibility = View.GONE
                buttonSignUpFinish.visibility = View.VISIBLE
                Toast.makeText(activity, "Authentication failed: " + task.exception, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Authentication success!" + task.exception, Toast.LENGTH_SHORT).show()
                fragmentManager.beginTransaction().remove(this).commit()
            }
        }
    }


}
