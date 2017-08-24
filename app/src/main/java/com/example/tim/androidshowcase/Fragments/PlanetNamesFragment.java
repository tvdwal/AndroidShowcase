package com.example.tim.androidshowcase.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.tim.androidshowcase.R;

/**
 * Created by tvandewal on 21-8-2017.
 */

public class PlanetNamesFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        setupOnClickListener(view, R.id.radioButtonEarth);
        setupOnClickListener(view, R.id.radioButtonMars);
        setupOnClickListener(view, R.id.radioButtonMercury);
        setupOnClickListener(view, R.id.radioButtonNeptune);
        return view;
    }

    @Override
    public void onClick(View v) {
        RadioButton rb = (RadioButton)v;
        int rbIndex = rb.getId();
        int descriptionId = translateIdToDescriptionId(rbIndex);
        int planetresourceId = translateIdToImageResourceId(rbIndex);
        CharSequence text = rb.getText();

        PlanetFragmentCoordinator planetFragmentCoordinator = (PlanetFragmentCoordinator)getActivity();
        planetFragmentCoordinator.onPlanetSelectionChanged(descriptionId, planetresourceId);
    }

    private int translateIdToDescriptionId(int id) {
        switch (id) {
            case R.id.radioButtonEarth:
                return 0;
            case R.id.radioButtonMars:
                return 1;
            case R.id.radioButtonMercury:
                return 2;
            case R.id.radioButtonNeptune:
                return 3;
            default:
                return -1;
        }
    }

    private int translateIdToImageResourceId(int id) {
        switch (id) {
            case R.id.radioButtonEarth:
                return R.drawable.earth;
            case R.id.radioButtonMars:
                return R.drawable.mars;
            case R.id.radioButtonMercury:
                return R.drawable.mercury;
            case R.id.radioButtonNeptune:
                return R.drawable.neptune;
            default:
                return -1;
        }
    }

    private void setupOnClickListener(View view, int childViewId) {
        View childView = view.findViewById(childViewId);
        childView.setOnClickListener(this);
    }
}
