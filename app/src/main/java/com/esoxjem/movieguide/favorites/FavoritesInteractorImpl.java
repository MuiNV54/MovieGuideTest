package com.esoxjem.movieguide.favorites;

import com.esoxjem.movieguide.MovieModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arun
 */
class FavoritesInteractorImpl implements FavoritesInteractor
{
    private FavoritesStore favoritesStore;

    FavoritesInteractorImpl(FavoritesStore store)
    {
        favoritesStore = store;
    }

    @Override
    public void setFavorite(MovieModel movie)
    {
        favoritesStore.setFavorite(movie);
    }

    @Override
    public boolean isFavorite(String id)
    {
        return favoritesStore.isFavorite(id);
    }

    @Override
    public List<MovieModel> getFavorites()
    {
        try
        {
            return favoritesStore.getFavorites();
        } catch (IOException ignored)
        {
            return new ArrayList<>(0);
        }
    }

    @Override
    public void unFavorite(String id)
    {
        favoritesStore.unfavorite(id);
    }
}
