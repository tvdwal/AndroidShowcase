package com.example.tim.androidshowcase.Fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

import com.example.tim.androidshowcase.R;

/**
 * Created by tvandewal on 7-9-2017.
 */

public class PlanetNamesListFragment extends ListFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] planetNames = getResources().getStringArray(R.array.planetNames);
        ArrayAdapter<String> planetNamesAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, planetNames);
        setListAdapter(planetNamesAdapter);
    }
}
