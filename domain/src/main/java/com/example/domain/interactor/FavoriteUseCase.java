package com.example.domain.interactor;

import com.example.domain.Movie;
import com.example.domain.repository.MovieRepository;
import java.util.List;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public class FavoriteUseCase {
    private final MovieRepository mMovieRepository;

    public FavoriteUseCase(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    public void setFavorite(Movie movie) {
        mMovieRepository.setFavorite(movie);
    }

    public boolean isFavorite(String id) {
        return mMovieRepository.isFavorite(id);
    }

    public List<Movie> getFavorites() {
        return mMovieRepository.getFavorites();
    }

    public void unFavorite(String id) {
        mMovieRepository.unFavorite(id);
    }
}
