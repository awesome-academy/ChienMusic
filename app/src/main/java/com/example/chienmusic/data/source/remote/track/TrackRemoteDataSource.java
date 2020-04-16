package com.example.chienmusic.data.source.remote.track;

import android.content.Context;

import com.example.chienmusic.data.model.Track;
import com.example.chienmusic.data.service.DataService;
import com.example.chienmusic.data.service.NetworkService;
import com.example.chienmusic.data.source.TrackDataSource;

import java.util.List;

import io.reactivex.Observable;

public class TrackRemoteDataSource implements TrackDataSource.remote {

    private static TrackRemoteDataSource sSource;
    private DataService mDataService;

    private TrackRemoteDataSource(DataService dataService) {
        mDataService = dataService;
    }

    public static TrackRemoteDataSource getInstance(Context context) {
        if (sSource == null) {
            sSource = new TrackRemoteDataSource(NetworkService.getInstance(context));
        }
        return sSource;
    }

    @Override
    public Observable<List<Track>> getAllTrack() {
        return mDataService.getAllTracks();
    }
}
