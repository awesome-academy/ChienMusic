package com.example.chienmusic.constant;

import com.example.chienmusic.data.model.Track;
import com.example.chienmusic.data.model.User;

public interface Handle {
    interface handleClickTrack {
        void onClickTrackListener(Track track, User user, int position);
    }
}
