package com.example.data.repository.datasource;

import com.example.data.cache.FavoritesCache;
import com.example.data.cache.SortingOptionStore;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public class MovieDataSourceFactory {
    private final FavoritesCache mFavoritesCache;
    private final RemoteMovieDataSource mRemoteMovieDataSource;
    private final SortingOptionStore mSortingOptionStore;

    @Inject
    public MovieDataSourceFactory(FavoritesCache favoritesCache,
            RemoteMovieDataSource remoteMovieDataSource, SortingOptionStore sortingOptionStore) {
        mFavoritesCache = favoritesCache;
        mRemoteMovieDataSource = remoteMovieDataSource;
        mSortingOptionStore = sortingOptionStore;
    }

    public DiskMovieDataSource createDiskDataSource() {
        return new DiskMovieDataSourceImpl(mFavoritesCache, mSortingOptionStore);
    }

    public RemoteMovieDataSource createRemoteMovieDataSource() {
        return mRemoteMovieDataSource;
    }
}
