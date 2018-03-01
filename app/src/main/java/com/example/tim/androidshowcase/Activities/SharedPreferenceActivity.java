package com.example.tim.androidshowcase.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tim.androidshowcase.Constants;
import com.example.tim.androidshowcase.R;
import java.util.Map;

/**
 * Created by tvandewal on 1-3-2018.
 */

public class SharedPreferenceActivity extends Activity {

    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreference);
        editText = (EditText)findViewById(R.id.editTextSharedPreference);
        Button update = (Button)findViewById(R.id.buttonSharedPreferenceUpdateLocal);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLatestActivity();
            }
        });

        insertLocalSharedPreferences();
    }


    private void insertLocalSharedPreferences()
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
}
