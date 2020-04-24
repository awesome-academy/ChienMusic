package com.example.chienmusic.data.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class Genre {
    private String mTitle;
    private int mImage;

    public Genre() {

    }

    public Genre(String title, int image) {
        mTitle = title;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getImage() {
        return mImage;
    }

    @BindingAdapter({"mAvatarGenresLocal"})
    public static void loadImageGenresLocal(ImageView view, int image) {
        Glide.with(view.getContext()).load(image).into(view);
    }

    public void setImage(int image) {
        mImage = image;
    }
}
