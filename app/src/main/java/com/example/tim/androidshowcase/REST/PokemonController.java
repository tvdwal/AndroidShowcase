package com.example.tim.androidshowcase.REST;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.tim.androidshowcase.RestClientActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tim on 12-7-2017.
 */

public class PokemonController implements Callback<Pokemon> {

    static final String REST_TAG = "REST";
    static final String BASE_URL = "http://pokeapi.co/api/v2/";
    private Context context;

    public void start(String pokemonId, Context context) {
        this.context = context;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PokemonApi pokemonApi = retrofit.create(PokemonApi.class);

        Call<Pokemon> call = pokemonApi.getPokemon(pokemonId);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
        if (response.isSuccessful()) {
            Pokemon pokemon = response.body();
            Intent i = new Intent();
            i.setAction(RestClientActivity.MyPokemonReceiver.ACTION);
            i.putExtra("pokemon", pokemon.toString());
            context.sendBroadcast(i);
        }
        else {
            Log.e(REST_TAG, response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<Pokemon> call, Throwable t) {
        t.printStackTrace();
    }
}
