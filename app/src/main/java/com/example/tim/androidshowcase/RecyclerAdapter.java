package com.example.tim.androidshowcase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Tim on 4-7-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DataObjectHolder> {

    ArrayList<DataObject> myDataObjects;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;
        DataObject mDataObject;

        public DataObjectHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.recycler_view_item_image);
            mTextView1 = (TextView) itemView.findViewById(R.id.recycler_view_item_text_1);
            mTextView2 = (TextView) itemView.findViewById(R.id.recycler_view_item_text_2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Click!", Toast.LENGTH_SHORT).show();
            //Context context = itemView.getContext();
            //Intent showPhotoIntent = new Intent(context, RecyclerViewSharedElementActivity.class);
            //showPhotoIntent.putExtra(PHOTO_KEY, mDataObject);
            //context.startActivity(showPhotoIntent);
        }

        public void bindDataObject(DataObject dataObject) {
            mDataObject = dataObject;
            mImageView.setImageResource(dataObject.getResId());
            mTextView1.setText(dataObject.getTitle());
            mTextView2.setText(dataObject.getDescription());
        }
    }

    public RecyclerAdapter(ArrayList<DataObject> dataObjects) {
        myDataObjects = dataObjects;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_row, parent, false);
        return new DataObjectHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        DataObject dataObject = myDataObjects.get(position);
        holder.bindDataObject(dataObject);
    }

    @Override
    public int getItemCount() {
        return myDataObjects.size();
    }
}