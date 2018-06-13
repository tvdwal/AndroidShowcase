package com.example.tim.androidshowcase.REST

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class PokemonViewModel: ViewModel() {

    val pokemon = MutableLiveData<String>()

    init {
        pokemon.value = ""
    }
}