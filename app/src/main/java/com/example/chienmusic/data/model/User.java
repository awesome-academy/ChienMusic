package com.example.chienmusic.data.model;

public class User {
    private String mId;
    private String mName;
    private String mAvatarUrl;
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
