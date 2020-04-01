package com.example.chienmusic.data.model;

public class Track {
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

        public Track builder() {
            return new Track(this);
        }
    }

    public String getmArtworkUrl() {
        return mArtworkUrl;
    }

    public void setmArtworkUrl(String mArtworkUrl) {
        this.mArtworkUrl = mArtworkUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmGenre() {
        return mGenre;
    }

    public void setmGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public String getmPermalinkUrl() {
        return mPermalinkUrl;
    }

    public void setmPermalinkUrl(String mPermalinkUrl) {
        this.mPermalinkUrl = mPermalinkUrl;
    }

    public String getmUri() {
        return mUri;
    }

    public void setmUri(String mUri) {
        this.mUri = mUri;
    }

    public String getmStreamUrl() {
        return mStreamUrl;
    }

    public void setmStreamUrl(String mStreamUrl) {
        this.mStreamUrl = mStreamUrl;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmDuration() {
        return mDuration;
    }

    public void setmDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public int getmDownloadCount() {
        return mDownloadCount;
    }

    public void setmDownloadCount(int mDownloadCount) {
        this.mDownloadCount = mDownloadCount;
    }

    public boolean ismIsDownloadable() {
        return mIsDownloadable;
    }

    public void setmIsDownloadable(boolean mIsDownloadable) {
        this.mIsDownloadable = mIsDownloadable;
    }
}
