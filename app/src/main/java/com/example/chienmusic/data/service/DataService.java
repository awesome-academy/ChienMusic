package com.example.chienmusic.data.service;

import com.example.chienmusic.BuildConfig;
import com.example.chienmusic.data.model.Track;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DataService {
    @GET("/tracks?client_id=" + BuildConfig.API_KEY)
    Observable<List<Track>> getAllTracks();
}
