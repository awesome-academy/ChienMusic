package com.example.chienmusic.data.source.local.genres;

import com.example.chienmusic.R;
import com.example.chienmusic.constant.GenreEntity;
import com.example.chienmusic.data.model.Genre;
import com.example.chienmusic.data.source.GenresDataSource;

import java.util.ArrayList;
import java.util.List;

public class LocalGenresDataSource implements GenresDataSource {
    @Override
    public List<Genre> getGenres() {
        List<Genre> genreList = new ArrayList<>();

        Genre ambient = new Genre(GenreEntity.AMBIENT_TITLE, R.raw.ambient_genre);
        Genre alternative = new Genre(GenreEntity.ALTERNATIVE_TITLE, R.raw.alternative_genre);
        Genre classical = new Genre(GenreEntity.CLASSICAL_TITLE, R.raw.classical_genre);
        Genre country = new Genre(GenreEntity.COUNTRY_TITLE, R.raw.country_genre);
        Genre hip_hop = new Genre(GenreEntity.HIP_HOP_TITLE, R.raw.hip_hop);
        Genre indie = new Genre(GenreEntity.INDIE_TITLE, R.raw.indie_genre);
        Genre pop = new Genre(GenreEntity.POP_TITLE, R.raw.pop_music);
        Genre other = new Genre(GenreEntity.OTHER_TITLE, R.raw.other_genre);

        genreList.add(ambient);
        genreList.add(alternative);
        genreList.add(classical);
        genreList.add(country);
        genreList.add(hip_hop);
        genreList.add(indie);
        genreList.add(pop);
        genreList.add(other);

        return genreList;
    }
}
