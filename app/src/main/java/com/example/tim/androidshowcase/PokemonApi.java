package com.example.tim.androidshowcase;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Tim on 12-7-2017.
 */

public interface PokemonApi {
    @GET("pokemon/{nr}")
    Call<Pokemon> getPokemon(@Path("nr") String user);
}
