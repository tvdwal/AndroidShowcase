package com.example.tim.androidshowcase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tim.androidshowcase.Recycler.DataObject;
import com.example.tim.androidshowcase.Recycler.RecyclerAdapter;

import java.util.ArrayList;

public class RecyclerViewSharedElementActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    RecyclerAdapter mRecyclerAdapter;
    ArrayList<DataObject> mDataObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_shared_element);

        initiateRecyclerView();
    }

    private void initiateRecyclerView() {
        fillArrayListWithPhotos();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerAdapter = new RecyclerAdapter(mDataObjectList);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    private void fillArrayListWithPhotos() {
        mDataObjectList = new ArrayList<>();
        mDataObjectList.add(new DataObject(R.drawable.ic_camera_enhance_black_48dp, "Title 1", loremIpsum()));
        mDataObjectList.add(new DataObject(R.drawable.ic_camera_enhance_black_48dp, "Title 2", loremIpsum()));
        mDataObjectList.add(new DataObject(R.drawable.ic_camera_enhance_black_48dp, "Title 3", loremIpsum()));
        mDataObjectList.add(new DataObject(R.drawable.ic_camera_enhance_black_48dp, "Title 4", loremIpsum()));
    }

    private String loremIpsum() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
    }
}
