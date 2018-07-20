package com.example.tim.androidshowcase.REST

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.IntentFilter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.tim.androidshowcase.BR

import com.example.tim.androidshowcase.R
import com.example.tim.androidshowcase.databinding.ActivityRestClientBinding
import kotlinx.android.synthetic.main.activity_rest_client.*

class RestClientActivity : AppCompatActivity() {

    private lateinit var pokemonViewModel: PokemonViewModel
    private lateinit var myPokemonReceiver: MyPokemonReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        pokemonViewModel.pokemon.observe(this, Observer {
            rest_view_text_view.text = it
        })
        
        val binding: ActivityRestClientBinding = DataBindingUtil.setContentView(this, R.layout.activity_rest_client)
        binding.setVariable(BR.pokemonViewModel, pokemonViewModel)
        binding.executePendingBindings()


        val adapter = ArrayAdapter.createFromResource(this, R.array.rest_request_types, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        rest_view_spinner.adapter = adapter
        rest_view_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        rest_view_button.setOnClickListener { executeRestCall(rest_view_edit_text.text.toString()) }

        myPokemonReceiver = MyPokemonReceiver(pokemonViewModel)
        this.registerReceiver(myPokemonReceiver, IntentFilter(MyPokemonReceiver.action))
    }

    private fun executeRestCall(pokemonId: String) {
        val intent = Intent(this, RestService::class.java)
        intent.action = RestService.action_request_pokemon
        intent.putExtra(RestService.extra_request_pokemon_id, pokemonId)
        startService(intent)
    }
}
