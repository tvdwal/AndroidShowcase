package com.example.tim.androidshowcase.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tim.androidshowcase.Constants;
import com.example.tim.androidshowcase.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtons();
        setLatestActivity();
    }

    private void setButtons()
    {
        Button b = (Button)findViewById(R.id.btnRecyclerViewSharedElement);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RecyclerViewSharedElementActivity.class);
                startActivity(i);
            }
        });

        Button c = (Button)findViewById(R.id.btnRestClient);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RestClientActivity.class);
                startActivity(i);
            }
        });

        Button f = (Button)findViewById(R.id.btnFragments);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentsActivity.class);
                startActivity(i);
            }
        });

        Button v = (Button)findViewById(R.id.btnViewModel);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewModelActivity.class);
                startActivity(i);
            }
        });

        Button s = (Button)findViewById(R.id.btnSharedPreferences);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SharedPreferenceActivity.class);
                startActivity(i);
            }
        });
    }

    private void setLatestActivity()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constants.PREF_FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.LATEST_ACTIVITY, "MAIN_ACTIVITY");
        editor.apply();
    }

}
