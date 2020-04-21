package com.example.chienmusic.ui.home;

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
import com.example.chienmusic.data.model.Track;
import com.example.chienmusic.databinding.FragmentHomeBinding;
import com.example.chienmusic.ui.home.adapter.TrackAdapter;
import com.example.chienmusic.viewmodel.HomeViewModel;

import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerTrack;
    private TrackAdapter mTrackAdapter;
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
        setUpRecycler();
        return mHomeBinding.getRoot();
    }

    private void setUpRecycler() {
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
    }
}
