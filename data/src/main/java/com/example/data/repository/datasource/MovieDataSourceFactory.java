package com.example.data.repository.datasource;

import com.example.data.cache.FavoritesCache;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public class MovieDataSourceFactory {
    private final FavoritesCache mFavoritesCache;
    private final RemoteMovieDataSource mRemoteMovieDataSource;

    @Inject
    public MovieDataSourceFactory(FavoritesCache favoritesCache,
            RemoteMovieDataSource remoteMovieDataSource) {
        mFavoritesCache = favoritesCache;
        mRemoteMovieDataSource = remoteMovieDataSource;
    }

    public DiskMovieDataSource createDiskDataSource() {
        return new DiskMovieDataSourceImpl(mFavoritesCache);
    }

    public RemoteMovieDataSource createRemoteMovieDataSource() {
        return mRemoteMovieDataSource;
    }
}
