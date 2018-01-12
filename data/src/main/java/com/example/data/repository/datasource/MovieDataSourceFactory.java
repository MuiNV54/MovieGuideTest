package com.example.data.repository.datasource;

import android.content.Context;
import com.example.data.cache.FavoritesCache;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public class MovieDataSourceFactory {
    private final FavoritesCache mFavoritesCache;

    public MovieDataSourceFactory(FavoritesCache favoritesCache) {
        mFavoritesCache = favoritesCache;
    }

    public DiskMovieDataSource createDiskDataSource() {
        return new DiskMovieDataSourceImpl(mFavoritesCache);
    }
}
