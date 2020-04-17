package com.example.chienmusic.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.chienmusic.data.model.Track;
import com.example.chienmusic.data.repository.TrackRepository;
import com.example.chienmusic.data.source.remote.track.TrackRemoteDataSource;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Track>> mTrackData;
    private CompositeDisposable mCompositeDisposable;
    private TrackRepository mTrackRepository;
    private Context mContext;

    public void initViewModel(Context context) {
        mCompositeDisposable = new CompositeDisposable();
        mTrackRepository = TrackRepository.getInstance(TrackRemoteDataSource.getInstance(context));
        mContext = context;
    }

    public LiveData<List<Track>> getTracks() {
        if (mTrackData == null) {
            mTrackData = new MutableLiveData<List<Track>>();
            loadTracks();
        }
        return mTrackData;
    }

    private void loadTracks() {
        Disposable disposable = mTrackRepository.getAllTrack()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(response -> handleResponse(response),
                        error -> handleError(error));
        mCompositeDisposable.add(disposable);
    }

    private void handleError(Throwable error) {
        Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void handleResponse(List<Track> tracks) {
        mTrackData.setValue(tracks);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.dispose();
    }
}
