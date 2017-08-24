package com.example.tim.androidshowcase.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.MediaStore;
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
        int index = translateIdToIndex(rb.getId());
        CharSequence text = rb.getText();

        PlanetFragmentCoordinator planetFragmentCoordinator = (PlanetFragmentCoordinator)getActivity();
        planetFragmentCoordinator.onPlanetSelectionChanged(index);
    }

    private int translateIdToIndex(int id) {
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

    private void setupOnClickListener(View view, int childViewId) {
        View childView = view.findViewById(childViewId);
        childView.setOnClickListener(this);
    }
}
