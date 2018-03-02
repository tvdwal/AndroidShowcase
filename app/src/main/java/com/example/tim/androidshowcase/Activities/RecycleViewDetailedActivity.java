package com.example.tim.androidshowcase.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tim.androidshowcase.R;
import com.example.tim.androidshowcase.Recycler.DataObject;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_recycle_view_detailed)
public class RecycleViewDetailedActivity extends AppCompatActivity {

    @ViewById(R.id.recycler_detailed_view_image)
    ImageView imageView;

    @ViewById(R.id.recycler_detailed_view_title)
    TextView textViewTitle;

    @ViewById(R.id.recycler_detailed_view_description)
    TextView textViewDescription;


    @AfterViews
    public void FillViewWithData() {
        DataObject dataObject = (DataObject) getIntent().getSerializableExtra("source");
        imageView.setImageResource(dataObject.getResId());
        textViewTitle.setText(dataObject.getTitle());
        textViewDescription.setText(dataObject.getDescription());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
