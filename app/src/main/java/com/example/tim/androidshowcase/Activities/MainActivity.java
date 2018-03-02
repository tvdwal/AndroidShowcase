package com.example.tim.androidshowcase.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tim.androidshowcase.Constants;
import com.example.tim.androidshowcase.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Click(R.id.btnRecyclerViewSharedElement)
    void btnRecyclerViewSharedElementClicked()
    {
        startActivity(new Intent(this, RecyclerViewSharedElementActivity_.class));
    }

    @Click(R.id.btnRestClient)
    void btnRestClientClicked()
    {
        Intent i = new Intent(this, RestClientActivity_.class);
        startActivity(i);
    }

    @Click(R.id.btnFragments)
    void btnFragmentsClicked()
    {
        Intent i = new Intent(this, FragmentsActivity_.class);
        startActivity(i);
    }

    @Click(R.id.btnViewModel)
    void btnViewModelClicked()
    {
        Intent i = new Intent(this, ViewModelActivity_.class);
        startActivity(i);
    }

    @Click(R.id.btnSharedPreferences)
    void btnSharedPreferencesClicked()
    {
        Intent i = new Intent(this, SharedPreferenceActivity_.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setLatestActivity();
    }

    private void setLatestActivity()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constants.PREF_FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.LATEST_ACTIVITY, "MAIN_ACTIVITY");
        editor.apply();
    }

}
