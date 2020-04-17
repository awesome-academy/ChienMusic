package com.example.chienmusic.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chienmusic.R;
import com.example.chienmusic.data.model.Track;
import com.example.chienmusic.databinding.ItemTrackBinding;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<Track> mTracks;

    public void setData(List<Track> tracks) {
        mTracks = tracks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemTrackBinding binding = DataBindingUtil.inflate(

                layoutInflater,
                R.layout.item_track,
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Track track = mTracks.get(position);
        holder.bind(track);
    }

    @Override
    public int getItemCount() {
        return mTracks == null ? 0 : mTracks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemTrackBinding mBinding;

        public ViewHolder(@NonNull ItemTrackBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        public void bind(Track track) {
            mBinding.setTrack(track);
            mBinding.executePendingBindings();
        }
    }
}
