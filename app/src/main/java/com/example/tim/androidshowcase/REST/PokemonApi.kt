package com.example.tim.androidshowcase.REST

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Tim on 12-7-2017.
 */

interface PokemonApi {
    @GET("pokemon/{nr}")
    fun getPokemon(@Path("nr") nr: String): Call<Pokemon>
}
