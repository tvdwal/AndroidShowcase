package com.example.tim.androidshowcase.REST

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class MyPokemonReceiver(viewModel: PokemonViewModel) : BroadcastReceiver() {

    private val viewModel: PokemonViewModel = viewModel

    companion object {
        const val action = "com.example.tim.androidshowcase.ACTION_POKEMON"
    }


    override fun onReceive(context: Context, intent: Intent) {
         viewModel.pokemon.value = intent.getStringExtra("pokemon")
    }


}