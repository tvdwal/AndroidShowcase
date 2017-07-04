package com.example.tim.androidshowcase;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Source copied from https://www.raywenderlich.com/126528/android-recyclerview-tutorial
 */

public class DataObject implements Serializable {

    private int mResId;
    private String mTitle;
    private String mDescription;

    public DataObject(int drawable, String title, String description) {
        mResId = drawable;
        mTitle = title;
        mDescription = description;
    }

    public int getResId() {
        return mResId;
    }

    public void setResId(int mResId) {
        this.mResId = mResId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}