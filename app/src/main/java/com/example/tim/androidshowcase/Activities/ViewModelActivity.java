package com.example.tim.androidshowcase.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tim.androidshowcase.R;

import org.w3c.dom.Text;

/**
 * Created by tvandewal on 19-12-2017.
 */

public class ViewModelActivity extends Activity {

    int counter = 0;
    TextView tvCounter;
    Button btnPlusOne;
    Button btnPlusTwo;
    Button btnMinusOne;
    Button btnMinusTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel);

        tvCounter = (TextView)findViewById(R.id.textViewCounter);
        btnPlusOne = (Button)findViewById(R.id.buttonPlusOne);
        btnPlusTwo = (Button)findViewById(R.id.buttonPlusTwo);
        btnMinusOne = (Button)findViewById(R.id.buttonMinusOne);
        btnMinusTwo = (Button)findViewById(R.id.buttonMinusTwo);
        btnPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCounter(true, 1);
            }
        });
        btnPlusTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCounter(true, 2);
            }
        });
        btnMinusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCounter(false, 1);
            }
        });
        btnMinusTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCounter(false, 2);
            }
        });
    }

    private void updateCounter(boolean increment, int value)
    {
        if (increment)
        {
            counter += value;
        }
        else
        {
            counter -= value;
        }
        tvCounter.setText(String.valueOf(counter));
    }
}
