package com.example.chienmusic.data.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private String mId;

    @SerializedName("username")
    private String mName;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("permalink_url")
    private String mLinkUser;

    public User() {

    }

    public User(String id, String name, String avatarUrl, String linkUser) {
        mId = id;
        mName = name;
        mAvatarUrl = avatarUrl;
        mLinkUser = linkUser;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    @BindingAdapter({"mAvatarUserUrl"})
    public static void loadImageUser(ImageView view, String imgUrl) {
        Glide.with(view.getContext()).load(imgUrl).into(view);
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getLinkUser() {
        return mLinkUser;
    }

    public void setLinkUser(String linkUser) {
        mLinkUser = linkUser;
    }
}
