package com.example.data.repository.datasource;

import com.example.data.cache.FavoritesCache;
import com.example.data.cache.SortingOptionStore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nguyen.van.mui on 19/01/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class MovieDataSourceFactoryTest {

    private MovieDataSourceFactory mSourceFactory;

    @Mock
    FavoritesCache mockFavoritesCache;
    @Mock
    RemoteMovieDataSource mockRemoteMovieDataSource;
    @Mock
    SortingOptionStore mockSortingOptionStore;

    @Before
    public void setup() {
        mSourceFactory = new MovieDataSourceFactory(mockFavoritesCache, mockRemoteMovieDataSource,
                mockSortingOptionStore);
    }

    @Test
    public void testCreateDiskDataSource() {
        DiskMovieDataSource dataSource = mSourceFactory.createDiskDataSource();

        assertThat(dataSource, is(notNullValue()));
    }

    @Test
    public void testCreateRemoteDataSource() {
        RemoteMovieDataSource dataSource = mSourceFactory.createRemoteMovieDataSource();

        assertThat(dataSource, is(notNullValue()));
    }
}
