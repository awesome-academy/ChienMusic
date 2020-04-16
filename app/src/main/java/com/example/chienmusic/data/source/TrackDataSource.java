package com.example.chienmusic.data.source;

import com.example.chienmusic.data.model.Track;

import java.util.List;

import io.reactivex.Observable;

public interface TrackDataSource {
    interface remote {
        Observable<List<Track>> getAllTrack();
    }
}
