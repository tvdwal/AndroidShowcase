package com.example.tim.androidshowcase.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tim.androidshowcase.R;
import com.example.tim.androidshowcase.Recycler.DataObject;

public class RecycleViewDetailedActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewTitle;
    TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_detailed);

        imageView = (ImageView)findViewById(R.id.recycler_detailed_view_image);
        textViewTitle = (TextView)findViewById(R.id.recycler_detailed_view_title);
        textViewDescription = (TextView)findViewById(R.id.recycler_detailed_view_description);

        FillViewWithData(getIntent());
    }

    private void FillViewWithData(Intent intent) {
        DataObject dataObject = (DataObject) intent.getSerializableExtra("source");
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
