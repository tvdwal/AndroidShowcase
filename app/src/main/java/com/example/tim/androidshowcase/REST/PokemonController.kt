package com.example.tim.androidshowcase.REST

import android.content.Context
import android.content.Intent
import android.util.Log

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Tim on 12-7-2017.
 */

class PokemonController : Callback<Pokemon> {
    companion object {

        internal const val REST_TAG = "REST"
        internal const val BASE_URL = "http://pokeapi.co/api/v2/"
    }

    private var context: Context? = null

    fun start(pokemonId: String, context: Context) {
        this.context = context
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        val pokemonApi = retrofit.create(PokemonApi::class.java)

        val call = pokemonApi.getPokemon(pokemonId)
        call.enqueue(this)
    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        if (response.isSuccessful) {
            val pokemon = response.body()
            val i = Intent()
            i.action = MyPokemonReceiver.action
            i.putExtra("pokemon", pokemon!!.toString())
            context!!.sendBroadcast(i)
        } else {
            Log.e(REST_TAG, response.errorBody()!!.toString())
        }
    }

    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        t.printStackTrace()
    }

}
