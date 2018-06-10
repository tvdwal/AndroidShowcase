package com.example.tim.androidshowcase.Login


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import com.android.databinding.library.baseAdapters.BR

import com.example.tim.androidshowcase.R
import com.example.tim.androidshowcase.databinding.FragmentLoginSignUpBinding
import kotlinx.android.synthetic.main.fragment_login_sign_up.*

class SignUpFragment : Fragment(), TextWatcher {

    companion object {
        const val tag: String = "LoginFragment"
    }

    lateinit var loginViewModel: LoginViewModel

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
        val animation :Animation = AlphaAnimation(0f,1f)
        animation.interpolator = DecelerateInterpolator()
        animation.duration = 2000

        layoutSignUpPassword.visibility = View.GONE
        layoutSignUpPasswordConfirm.visibility = View.GONE
        layoutSignUpFinish.visibility = View.GONE

        val buttonSignUp: Button = rootView.findViewById(R.id.buttonSignUpEmail)
        buttonSignUp.setOnClickListener {
            if (animation.hasEnded()) {
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
                layoutSignUpFinish.visibility = View.VISIBLE
                layoutSignUpFinish.startAnimation(animation)
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

    private fun comparePasswords() {
        val s1 = editTextLoginPass.text.toString()
        val s2 = editTextLoginPassConfirm.text.toString()
        if (s1 == "" && s2 == "") {
            textViewPasswordCheck.text = getString(R.string.passwords_empty)
            return
        }
        if (s1 == s2) {
            textViewPasswordCheck.text = getString(R.string.passwords_match)
        } else {
            textViewPasswordCheck.text = getString(R.string.passwords_dont_match)
        }
    }


}
