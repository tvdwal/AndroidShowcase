package com.example.tim.androidshowcase.Activities;

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

import com.example.tim.androidshowcase.R;
import com.example.tim.androidshowcase.REST.Pokemon;
import com.example.tim.androidshowcase.REST.PokemonController;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EReceiver;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_rest_client)
public class RestClientActivity extends AppCompatActivity {

    @ViewById(R.id.rest_view_text_view)
    TextView textViewRestResult;

    @ViewById(R.id.rest_view_edit_text)
    EditText editTextRestUrl;

    @ViewById(R.id.rest_view_spinner)
    Spinner spinnerRequestTypes;

    @Click(R.id.rest_view_button)
    void restViewButtonClicked()
    {
        ExecuteRestCall(editTextRestUrl.getText().toString());
    }

    MyPokemonReceiver myPokemonReceiver;

    @AfterViews()
    void initView(){
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
    }

    @AfterViews
    void registerService(){
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
            updateTextView(intent.getStringExtra("pokemon"));
        }

        public void updateTextView(String txt) {
            textViewRestResult.setText(txt);
        }
    }
}
