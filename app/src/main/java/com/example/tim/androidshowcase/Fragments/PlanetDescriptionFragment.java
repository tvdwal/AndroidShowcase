package com.example.tim.androidshowcase.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tim.androidshowcase.R;

/**
 * Created by tvandewal on 21-8-2017.
 */

public class PlanetDescriptionFragment extends Fragment {
    private TextView textViewDescription;
    private String[] planetDescriptions;
    private int latestDescriptionIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        planetDescriptions = getResources().getStringArray(R.array.planetDescriptions);
        textViewDescription = (TextView)  view.findViewById(R.id.textViewPlanetDescription);

        setDisplayedDescription(0);

        return view;
    }

    public void setDisplayedDescription(int index) {
        latestDescriptionIndex = index;
        textViewDescription.setText(planetDescriptions[latestDescriptionIndex]);
    }
}
