package com.example.tim.androidshowcase.Activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.app.FragmentManager;

import com.example.tim.androidshowcase.Fragments.PlanetDescriptionFragment;
import com.example.tim.androidshowcase.Fragments.PlanetFragmentCoordinator;
import com.example.tim.androidshowcase.Fragments.PlanetImageFragment;
import com.example.tim.androidshowcase.R;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_fragments)
public class FragmentsActivity extends FragmentActivity implements PlanetFragmentCoordinator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPlanetSelectionChanged(int descriptionId, int imageResourceId) {
        FragmentManager manager = getFragmentManager();

        PlanetDescriptionFragment planetDescriptionFragment =
                (PlanetDescriptionFragment)manager.findFragmentById(R.id.planetDescriptionFragment);
        planetDescriptionFragment.setDisplayedDescription(descriptionId);

        PlanetImageFragment planetImageFragment =
                (PlanetImageFragment)manager.findFragmentById(R.id.planetImageFragment);
        planetImageFragment.setDisplayedDescription(imageResourceId);
    }
}
