package com.example.tim.androidshowcase.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tim.androidshowcase.R;

/**
 * Created by tvandewal on 21-8-2017.
 */

public class PlanetImageFragment extends Fragment {
    private ImageView planetImageView;
    private int latestImageResId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        planetImageView = (ImageView)view.findViewById(R.id.imageViewPlanetImage);

        setDisplayedDescription(R.drawable.earth);

        return view;
    }

    public void setDisplayedDescription(int resId) {
        latestImageResId = resId;
        planetImageView.setImageResource(latestImageResId);
    }
}
