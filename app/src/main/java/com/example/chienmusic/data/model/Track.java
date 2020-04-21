package com.example.chienmusic.data.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.chienmusic.R;
import com.google.gson.annotations.SerializedName;

public class Track {
    @SerializedName("artwork_url")
    private String mArtworkUrl;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("genre")
    private String mGenre;

    @SerializedName("permalink_url")
    private String mPermalinkUrl;

    @SerializedName("uri")
    private String mUri;

    @SerializedName("stream_url")
    private String mStreamUrl;

    @SerializedName("id")
    private int mId;

    @SerializedName("duration")
    private int mDuration;

    @SerializedName("download_count")
    private int mDownloadCount;

    @SerializedName("downloadable")
    private boolean mIsDownloadable;

    @SerializedName("user")
    private User mUser;

    @SerializedName("username")
    private String mArtist;

    public Track(Builder builder) {
        mArtworkUrl = builder.mArtworkUrl;
        mTitle = builder.mTitle;
        mGenre = builder.mGenre;
        mPermalinkUrl = builder.mPermalinkUrl;
        mUri = builder.mUri;
        mStreamUrl = builder.mStreamUrl;
        mId = builder.mId;
        mDuration = builder.mDuration;
        mDownloadCount = builder.mDownloadCount;
        mIsDownloadable = builder.mIsDownloadable;
        mUser = builder.mUser;
        mArtist = builder.mArtist;
    }

    public static class Builder {
        private String mArtworkUrl;
        private String mTitle;
        private String mGenre;
        private String mPermalinkUrl;
        private String mUri;
        private String mStreamUrl;
        private int mId;
        private int mDuration;
        private int mDownloadCount;
        private boolean mIsDownloadable;
        private User mUser;
        private String mArtist;

        public Builder withArtworkUrl(String artworkUrl) {
            this.mArtworkUrl = artworkUrl;
            return this;
        }

        public Builder withTitle(String title) {
            this.mTitle = title;
            return this;
        }

        public Builder withGenre(String genre) {
            this.mGenre = genre;
            return this;
        }

        public Builder withPermalinkUrl(String permalinkUrl) {
            this.mPermalinkUrl = permalinkUrl;
            return this;
        }

        public Builder withUri(String uri) {
            this.mUri = uri;
            return this;
        }

        public Builder withStreamUrl(String streamUrl) {
            this.mStreamUrl = streamUrl;
            return this;
        }

        public Builder withId(int id) {
            this.mId = id;
            return this;
        }

        public Builder withDuration(int duration) {
            this.mDuration = duration;
            return this;
        }

        public Builder withDownloadCount(int downloadCount) {
            this.mDownloadCount = downloadCount;
            return this;
        }

        public Builder withIsDownloadable(Boolean isDownloadable) {
            this.mIsDownloadable = isDownloadable;
            return this;
        }

        public Builder withUser(User user) {
            this.mUser = user;
            return this;
        }

        public Builder withArtist(String artist) {
            this.mArtist = artist;
            return this;
        }

        public Track builder() {
            return new Track(this);
        }
    }

    public String getArtworkUrl() {
        return mArtworkUrl;
    }

    @BindingAdapter({"mAvatarTrackUrl"})
    public static void loadImageTrack(ImageView view, String imgUrl) {
        Glide.with(view.getContext()).load(imgUrl).placeholder(R.drawable.track_image_1).into(view);
    }

    public void setArtworkUrl(String artworkUrl) {
        mArtworkUrl = artworkUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public String getPermalinkUrl() {
        return mPermalinkUrl;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        mPermalinkUrl = permalinkUrl;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public String getStreamUrl() {
        return mStreamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        mStreamUrl = streamUrl;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getDownloadCount() {
        return mDownloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        mDownloadCount = downloadCount;
    }

    public boolean isDownloadable() {
        return mIsDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        mIsDownloadable = downloadable;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }
}
