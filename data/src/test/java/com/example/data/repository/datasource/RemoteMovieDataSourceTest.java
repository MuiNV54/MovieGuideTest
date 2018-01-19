package com.example.data.repository.datasource;

import com.example.data.network.TmdbWebService;
import com.example.domain.SortType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by nguyen.van.mui on 19/01/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class RemoteMovieDataSourceTest {

    private RemoteMovieDataSource mRemoteMovieDataSource;

    @Mock
    TmdbWebService mockTmdbWebService;

    @Before
    public void setup() {
        mRemoteMovieDataSource = new RemoteMovieDataSourceImpl(mockTmdbWebService);
    }

    @Test
    public void testGetReviews() {
        mRemoteMovieDataSource.getReviews("123");
        verify(mockTmdbWebService).reviews("123");
    }

    @Test
    public void testFetchMovies() {
        mRemoteMovieDataSource.fetchMovies(SortType.MOST_POPULAR);
        verify(mockTmdbWebService).popularMovies();
    }
}
