package com.example.domain.interactor;

import com.example.domain.SortType;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by nguyen.van.mui on 19/01/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class FetchMoviesTest {

    private FetchMovies mFetchMovies;

    @Mock
    private ThreadExecutor mThreadExecutor;
    @Mock
    private PostExecutionThread mPostExecutionThread;
    @Mock
    private MovieRepository mMovieRepository;

    @Before
    public void setUp() {
        mFetchMovies = new FetchMovies(mThreadExecutor, mPostExecutionThread, mMovieRepository);
    }

    @Test
    public void testGetUserListUseCaseObservableHappyCase() {
        mFetchMovies.buildUseCaseObservable(null);

        verify(mMovieRepository).fetchMovies(SortType.MOST_POPULAR);
        verifyZeroInteractions(mThreadExecutor);
        verifyZeroInteractions(mPostExecutionThread);
    }
}
