package com.esoxjem.movieguide.favorites;

import com.esoxjem.movieguide.MovieModel;

import java.util.List;

/**
 * @author arun
 */
public interface FavoritesInteractor
{
    void setFavorite(MovieModel movie);
    boolean isFavorite(String id);
    List<MovieModel> getFavorites();
    void unFavorite(String id);
}
