package com.example.tim.androidshowcase.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tim.androidshowcase.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
