package com.example.tim.androidshowcase.Login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val loginName = MutableLiveData<String>()
    val loginPass = MutableLiveData<String>()
    val loginRemember = MutableLiveData<Boolean>()

    init {
        loginName.value = ""
        loginPass.value = ""
        loginRemember.value = false
    }
}