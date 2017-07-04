import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tim.androidshowcase.R;
import com.example.tim.androidshowcase.RecyclerViewSharedElementActivity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tim on 4-7-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PhotoHolder> {

    ArrayList<Photo> myPhotos;

    public static class PhotoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;
        Photo mPhoto;

        private static final String PHOTO_KEY = "PHOTO";

        public PhotoHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.recycler_view_item_image);
            mTextView1 = (TextView) itemView.findViewById(R.id.recycler_view_item_text_1);
            mTextView2 = (TextView) itemView.findViewById(R.id.recycler_view_item_text_2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Click!", Toast.LENGTH_SHORT).show();
            Context context = itemView.getContext();
            Intent showPhotoIntent = new Intent(context, RecyclerViewSharedElementActivity.class);
            showPhotoIntent.putExtra(PHOTO_KEY, mPhoto);
            context.startActivity(showPhotoIntent);
        }

        public void bindPhoto(Photo photo) {
            mPhoto = photo;
            Picasso.with(mImageView.getContext()).load(photo.getUrl()).into(mImageView);
            mTextView1.setText(photo.getHumanDate());
            mTextView2.setText(photo.getExplanation());
        }
    }

    public RecyclerAdapter(ArrayList<Photo> photos) {
        myPhotos = photos;
    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_row, parent, false);
        return new PhotoHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {
        Photo photo = myPhotos.get(position);
        holder.bindPhoto(photo);
    }

    @Override
    public int getItemCount() {
        return myPhotos.size();
    }
}
