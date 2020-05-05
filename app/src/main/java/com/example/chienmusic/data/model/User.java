package com.example.chienmusic.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

public class User extends BaseObservable implements Parcelable {
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

    protected User(Parcel in) {
        mId = in.readString();
        mName = in.readString();
        mAvatarUrl = in.readString();
        mLinkUser = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mName);
        dest.writeString(mAvatarUrl);
        dest.writeString(mLinkUser);
    }
}
