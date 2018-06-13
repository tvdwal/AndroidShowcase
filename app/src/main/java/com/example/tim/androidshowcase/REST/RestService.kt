package com.example.tim.androidshowcase.REST

import android.app.IntentService
import android.content.Intent

class RestService(name: String) : IntentService(name) {

    companion object {
        const val action_request_pokemon: String = "REQUEST_POKEMON"

        const val extra_request_pokemon_id: String = "REQUEST_POKEMON_ID"
    }

    var pokemonController: PokemonController = PokemonController()

    constructor() : this("RestService")

    override fun onHandleIntent(intent: Intent?) {
        if (intent == null)
            return
        val action = intent.action
        val id = intent.getStringExtra(extra_request_pokemon_id)

        when(action) {
            action_request_pokemon -> requestPokemon(id)
            else -> {
                // do nothing
            }
        }
    }

    private fun requestPokemon(id: String) {
        pokemonController.start(id, this)
    }
}
