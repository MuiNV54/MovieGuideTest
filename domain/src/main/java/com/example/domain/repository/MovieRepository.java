package com.example.domain.repository;

import com.example.domain.Movie;
import java.util.List;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public interface MovieRepository {
    void setFavorite(Movie movie);

    boolean isFavorite(String id);

    List<Movie> getFavorites();

    void unFavorite(String id);
}
