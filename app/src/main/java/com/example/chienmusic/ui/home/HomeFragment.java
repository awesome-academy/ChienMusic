package com.example.chienmusic.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chienmusic.R;
import com.example.chienmusic.constant.Constant;
import com.example.chienmusic.constant.Handle;
import com.example.chienmusic.data.model.Track;
import com.example.chienmusic.data.model.User;
import com.example.chienmusic.data.repository.GenreRepository;
import com.example.chienmusic.data.source.local.genres.LocalGenresDataSource;
import com.example.chienmusic.databinding.FragmentHomeBinding;
import com.example.chienmusic.ui.home.adapter.GenreAdapter;
import com.example.chienmusic.ui.home.adapter.TrackAdapter;
import com.example.chienmusic.ui.playTrack.PlayTrackActivity;
import com.example.chienmusic.viewmodel.HomeViewModel;

import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerTrack;
    private RecyclerView mRecyclerGenres;
    private GenreRepository mGenreRepository;
    private TrackAdapter mTrackAdapter;
    private GenreAdapter mGenreAdapter;
    private FragmentHomeBinding mHomeBinding;
    private HomeViewModel mHomeViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mHomeBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_home,
                container,
                false
        );
        mHomeBinding.setHome(this);
        setUpRecyclerTrack();
        setUpRecyclerGenres();
        return mHomeBinding.getRoot();
    }

    private void setUpRecyclerGenres() {
        mRecyclerGenres = mHomeBinding.recyclerGenres;
        mGenreAdapter = new GenreAdapter();
        mHomeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        mHomeViewModel.initViewModel(getContext());
        mGenreRepository = GenreRepository.getInstance(new LocalGenresDataSource());
        mGenreAdapter.setData(mGenreRepository.getGenres());
        mRecyclerGenres.setAdapter(mGenreAdapter);
    }

    private void setUpRecyclerTrack() {
        mRecyclerTrack = mHomeBinding.recyclerAllSong;
        mTrackAdapter = new TrackAdapter();
        mHomeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        mHomeViewModel.initViewModel(getContext());
        mHomeViewModel.getTracks().observe(this, new Observer<List<Track>>() {
            @Override
            public void onChanged(List<Track> tracks) {
                mTrackAdapter.setData(tracks);
            }
        });
        mRecyclerTrack.setAdapter(mTrackAdapter);
        mTrackAdapter.setHandleClickTrack(new Handle.handleClickTrack() {
            @Override
            public void onClickTrackListener(Track track, User user, int position) {
                Intent intent = PlayTrackActivity.getIntent(getContext());
                Bundle bundle = new Bundle();
                bundle.putParcelable(Constant.BUNDLE_TRACK, track);
                bundle.putParcelable(Constant.BUNDLE_USER, user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
