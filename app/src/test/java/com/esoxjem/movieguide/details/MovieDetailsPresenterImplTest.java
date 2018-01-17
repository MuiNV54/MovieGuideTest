package com.esoxjem.movieguide.details;

import android.content.Context;
import com.esoxjem.movieguide.MovieModel;
import com.esoxjem.movieguide.ReviewModel;
import com.esoxjem.movieguide.RxSchedulerRule;
import com.esoxjem.movieguide.VideoModel;
import io.reactivex.Observable;
import java.net.SocketTimeoutException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * @author arunsasidharan
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieDetailsPresenterImplTest {
    @Rule
    public RxSchedulerRule rule = new RxSchedulerRule();
    @Mock
    private MovieDetailsView view;
    @Mock
    private MovieDetailsInteractor movieDetailsInteractor;
    @Mock
    private FavoritesInteractor favoritesInteractor;
    @Mock
    List<VideoModel> videos;
    @Mock
    MovieModel movie;
    @Mock
    List<ReviewModel> reviews;
    @Mock
    Context mContext;

    private MovieDetailsPresenterImpl movieDetailsPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        movieDetailsPresenter = new MovieDetailsPresenterImpl(movieDetailsInteractor, mContext);
        movieDetailsPresenter.setView(view);
    }

    @After
    public void teardown() {
        movieDetailsPresenter.destroy();
    }

    @Test
    public void shouldUnfavoriteIfFavoriteTapped() {
        when(movie.getId()).thenReturn("12345");
        when(favoritesInteractor.isFavorite(movie.getId())).thenReturn(true);

        movieDetailsPresenter.onFavoriteClick(movie);

        verify(view).showUnFavorited();
    }

    @Test
    public void shouldFavoriteIfUnfavoriteTapped() {
        when(movie.getId()).thenReturn("12345");
        when(favoritesInteractor.isFavorite(movie.getId())).thenReturn(false);

        movieDetailsPresenter.onFavoriteClick(movie);

        verify(view).showFavorited();
    }

    @Test
    public void shouldBeAbleToShowTrailers() {
        when(movie.getId()).thenReturn("12345");
        Observable<List<VideoModel>> responseObservable = Observable.just(videos);
        when(movieDetailsInteractor.getTrailers(movie.getId())).thenReturn(responseObservable);

        movieDetailsPresenter.showTrailers(movie);

        verify(view).showTrailers(videos);
    }

    @Test
    public void shouldFailSilentlyWhenNoTrailers() throws Exception {
        when(movie.getId()).thenReturn("12345");
        when(movieDetailsInteractor.getTrailers(movie.getId())).thenReturn(
                Observable.error(new SocketTimeoutException()));

        movieDetailsPresenter.showTrailers(movie);

        verifyZeroInteractions(view);
    }

    @Test
    public void shouldBeAbleToShowReviews() {
        Observable<List<ReviewModel>> responseObservable = Observable.just(reviews);
        when(movie.getId()).thenReturn("12345");
        when(movieDetailsInteractor.getReviews(movie.getId())).thenReturn(responseObservable);

        movieDetailsPresenter.showReviews(movie);

        verify(view).showReviews(reviews);
    }

    @Test
    public void shouldFailSilentlyWhenNoReviews() throws Exception {
        when(movie.getId()).thenReturn("12345");
        when(movieDetailsInteractor.getReviews(movie.getId())).thenReturn(
                Observable.error(new SocketTimeoutException()));

        movieDetailsPresenter.showReviews(movie);

        verifyZeroInteractions(view);
    }
}