package com.example.tim.androidshowcase.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.tim.androidshowcase.Constants;
import com.example.tim.androidshowcase.R;
import com.example.tim.androidshowcase.REST.Pokemon;
import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Map;

/**
 * Created by tvandewal on 1-3-2018.
 */
@EActivity(R.layout.activity_sharedpreference)
public class SharedPreferenceActivity extends Activity {

    @ViewById(R.id.editTextSharedPreference)
    EditText editText;

    @Click(R.id.buttonSharedPreferenceUpdateLocal)
    void buttonSharedPreferenceUpdateLocalClicked() {
        getLatestActivity();
    }

    @AfterViews
    public void insertLocalSharedPreferences()
    {
        /*
        Shared preferences should always be private. Use flag: MODE_PRIVATE
        Shared preference suggested filename:
            <package>.file_name.xml
            com.example.tim.androidshowcase.my_preference_file.xml
        Differnece between activity & Application level
        Activity level:
         */
        activitySharedPreferenceSave("A", 1);
        activitySharedPreferenceSave("B", 4);
        activitySharedPreferenceSave("C", 9);
        activitySharedPreferenceSave("D", 13);
        activitySharedPreferenceLoad();
    }

    private void activitySharedPreferenceSave(String key, int storeValue)
    {
        // initiation
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // add values
        editor.putInt(key, storeValue);

        // save
        editor.apply(); // or editor.commit()  <-- returns success bool
    }

    private void activitySharedPreferenceLoad()
    {
        // initiation
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        editText.setText("");

        // get all preferences from local xml & log them
        Map<String, ?> allPrefs = sharedPreferences.getAll();
        for(Map.Entry<String, ?> entry: allPrefs.entrySet())
        {
            String val = entry.getValue().toString();
            Log.d("SharedPreferenceEntries", val);
            editText.append("Key: " + entry.getKey() + ", Value: " + val + "\n");
        }
    }

    private void getLatestActivity()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constants.PREF_FILE_NAME, MODE_PRIVATE);
        String latestActivity = sharedPreferences.getString(Constants.LATEST_ACTIVITY, "");

        editText.append("Key: " + Constants.LATEST_ACTIVITY + ", Value: " + latestActivity + "\n");
    }

    public void addNonPrimitiveType(View view) {
        Pokemon pokemon = new Pokemon();
        pokemon.setHeight(181);
        pokemon.setWeight(80);
        pokemon.setName("Tim");
        pokemon.setId(0);

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //serialization
        Gson gson = new Gson();
        String jsonString = gson.toJson(pokemon, Pokemon.class);
        editor.putString("NONPRIMITIVE", jsonString);
        editor.apply();
    }

    public void addNonPrimitiveTypeTwo(View view) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String fromJson = sharedPreferences.getString("NONPRIMITIVE", "");

        //deserialization
        Gson gson = new Gson();
        Pokemon p = gson.fromJson(fromJson, Pokemon.class);
        editText.append(p.toString() + "\n");
    }
}
