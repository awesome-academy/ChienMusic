package com.example.chienmusic.data.repository;

import com.example.chienmusic.data.model.Track;
import com.example.chienmusic.data.source.TrackDataSource;
import com.example.chienmusic.data.source.remote.track.TrackRemoteDataSource;

import java.util.List;

import io.reactivex.Observable;

public class TrackRepository implements TrackDataSource.remote {

    private static TrackRepository sRepository;
    private TrackRemoteDataSource mSource;

    private TrackRepository (TrackRemoteDataSource remoteDataSource) {
        mSource = remoteDataSource;
    }

    public static TrackRepository getInstance(TrackRemoteDataSource remoteDataSource) {
        if (sRepository == null) {
            sRepository = new TrackRepository(remoteDataSource);
        }
        return sRepository;
    }

    @Override
    public Observable<List<Track>> getAllTrack() {
        return mSource.getAllTrack();
    }
}
