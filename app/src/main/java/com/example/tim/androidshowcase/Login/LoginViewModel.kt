package com.example.tim.androidshowcase.Login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel() {

    val loginName = MutableLiveData<String>()
    val loginPass = MutableLiveData<String>()
    val loginRemember = MutableLiveData<Boolean>()

    val firebaseAuth = FirebaseAuth.getInstance()

    init {
        loginName.value = ""
        loginPass.value = ""
        loginRemember.value = false
    }

}