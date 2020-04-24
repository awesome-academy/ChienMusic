package com.example.chienmusic.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chienmusic.R;
import com.example.chienmusic.data.model.Genre;
import com.example.chienmusic.databinding.ItemGenresBinding;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {

    private List<Genre> mGenres;

    public void setData(List<Genre> genres) {
        mGenres = genres;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GenreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemGenresBinding binding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_genres,
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreAdapter.ViewHolder holder, int position) {
        Genre genre = mGenres.get(position);
        holder.bind(genre);
    }

    @Override
    public int getItemCount() {
        return mGenres == null ? 0 : mGenres.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemGenresBinding mBinding;

        public ViewHolder(@NonNull ItemGenresBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        public void bind(Genre genre) {
            mBinding.setGenres(genre);
            mBinding.executePendingBindings();
        }
    }
}
