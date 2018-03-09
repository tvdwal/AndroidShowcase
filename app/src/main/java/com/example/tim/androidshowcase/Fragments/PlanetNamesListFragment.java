package com.example.tim.androidshowcase.Fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String[] planetNames = getActivity().getResources().getStringArray(R.array.planetNames);
        int planetDrawable = translateIdToImageResourceId(planetNames[position]);

        Log.d("LISTITEM", "position: " + position);
        Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_LONG).show();

        PlanetFragmentCoordinator planetFragmentCoordinator = (PlanetFragmentCoordinator)getActivity();
        planetFragmentCoordinator.onPlanetSelectionChanged(position, planetDrawable);

    }

    private int translateIdToImageResourceId(String name) {
        switch (name) {
            case "Earth":
                return R.drawable.earth;
            case "Mars":
                return R.drawable.mars;
            case "Mercury":
                return R.drawable.mercury;
            case "Neptune":
                return R.drawable.neptune;
            default:
                return -1;
        }
    }
}
