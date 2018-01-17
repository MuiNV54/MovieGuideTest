package com.example.data.repository.datasource;

import com.example.data.cache.FavoritesCache;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public class MovieDataSourceFactory {
    private final FavoritesCache mFavoritesCache;

    @Inject
    public MovieDataSourceFactory(FavoritesCache favoritesCache) {
        mFavoritesCache = favoritesCache;
    }

    public DiskMovieDataSource createDiskDataSource() {
        return new DiskMovieDataSourceImpl(mFavoritesCache);
    }
}
