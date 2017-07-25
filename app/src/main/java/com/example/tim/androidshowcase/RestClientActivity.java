package com.example.tim.androidshowcase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tim.androidshowcase.REST.Pokemon;
import com.example.tim.androidshowcase.REST.PokemonController;

public class RestClientActivity extends AppCompatActivity {

    TextView textViewRestResult;
    EditText editTextRestUrl;
    Spinner spinnerRequestTypes;
    Button buttonRequest;

    PokemonController restPokemonController;
    MyPokemonReceiver myPokemonReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_client);

        textViewRestResult = (TextView) findViewById(R.id.rest_view_text_view);
        editTextRestUrl = (EditText) findViewById(R.id.rest_view_edit_text);
        spinnerRequestTypes = (Spinner) findViewById(R.id.rest_view_spinner);
        buttonRequest = (Button) findViewById(R.id.rest_view_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.rest_request_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRequestTypes.setAdapter(adapter);
        spinnerRequestTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteRestCall(editTextRestUrl.getText().toString());
            }
        });

        myPokemonReceiver = new MyPokemonReceiver();
        this.registerReceiver(myPokemonReceiver, new IntentFilter(MyPokemonReceiver.ACTION));
    }

    private void ExecuteRestCall(String pokemonId) {
        PokemonController pokemonController = new PokemonController();
        pokemonController.start(pokemonId, this);
    }

    public class MyPokemonReceiver extends BroadcastReceiver {
        public static final String ACTION = "com.example.tim.androidshowcase.ACTION_POKEMON";
        @Override
        public void onReceive(Context context, Intent intent) {
            textViewRestResult.setText(intent.getStringExtra("pokemon"));
        }
    }
}
