package com.example.tim.androidshowcase.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tim.androidshowcase.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;

/**
 * Created by tvandewal on 19-12-2017.
 */

@EActivity(R.layout.activity_viewmodel)
public class ViewModelActivity extends Activity {

    @ViewById(R.id.textViewCounter)
    TextView tvCounter;

    @Click(R.id.buttonPlusOne)
    void buttonPlusOneClicked() {
        updateCounter(true, 1);
    }

    @Click(R.id.buttonPlusTwo)
    void buttonPlusTwoClicked() {
        updateCounter(true, 2);
    }

    @Click(R.id.buttonMinusOne)
    void buttonMinusOneClicked() {
        updateCounter(false, 1);
    }

    @Click(R.id.buttonMinusTwo)
    void buttonMinusTwoClicked() {
        updateCounter(false, 2);
    }

    int counter = 0;

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
