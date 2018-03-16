package com.example.tim.androidshowcase.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tim.androidshowcase.Constants;
import com.example.tim.androidshowcase.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        setButtons();
        setLatestActivity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.default_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";

        switch (item.getItemId())
        {
            case R.id.id_menu_item_account:
                msg = item.toString();
                break;
            case R.id.id_menu_item_android:
                msg = item.toString();
                break;
            case R.id.id_menu_item_delete:
                msg = item.toString();
                break;
            case R.id.id_menu_item_help:
                msg = item.toString();
                break;
            case R.id.id_menu_item_home:
                msg = item.toString();
                break;
            case R.id.id_menu_item_settings:
                msg = item.toString();
                break;
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    private void setToolbar()
    {
        toolbar = findViewById(R.id.toolbarMainActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitle("Welcome");
        toolbar.setSubtitle("Tim");
    }

    private void setButtons()
    {
        Button b = findViewById(R.id.btnRecyclerViewSharedElement);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RecyclerViewSharedElementActivity.class);
                startActivity(i);
            }
        });

        Button c = findViewById(R.id.btnRestClient);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RestClientActivity.class);
                startActivity(i);
            }
        });

        Button f = findViewById(R.id.btnFragments);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentsActivity.class);
                startActivity(i);
            }
        });

        Button v = findViewById(R.id.btnViewModel);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewModelActivity.class);
                startActivity(i);
            }
        });

        Button s = findViewById(R.id.btnSharedPreferences);
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
