package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.MovieModel;
import com.esoxjem.movieguide.mapper.MovieModelDataMapper;
import com.example.domain.Movie;
import com.example.domain.interactor.FetchMovies;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import javax.inject.Inject;

/**
 * @author arun
 */
class MoviesListingPresenterImpl implements MoviesListingPresenter {
    private MoviesListingView view;
    private FetchMovies mFetchMovies;
    private MovieModelDataMapper mModelDataMapper;

    @Inject
    public MoviesListingPresenterImpl(FetchMovies fetchMovies,
            MovieModelDataMapper modelDataMapper) {
        mFetchMovies = fetchMovies;
        mModelDataMapper = modelDataMapper;
    }

    @Override
    public void setView(MoviesListingView view) {
        this.view = view;
        displayMovies();
    }

    @Override
    public void displayMovies() {
        showLoading();
        mFetchMovies.execute(new DisposableObserver<List<Movie>>() {
            @Override
            public void onNext(List<Movie> movies) {
                onMovieFetchSuccess(mModelDataMapper.transform(movies));
            }

            @Override
            public void onError(Throwable e) {
                onMovieFetchFailed(e);
            }

            @Override
            public void onComplete() {

            }
        }, null);
    }

    private void showLoading() {
        if (isViewAttached()) {
            view.loadingStarted();
        }
    }

    private void onMovieFetchSuccess(List<MovieModel> movies) {
        if (isViewAttached()) {
            view.showMovies(movies);
        }
    }

    private void onMovieFetchFailed(Throwable e) {
        view.loadingFailed(e.getMessage());
    }

    private boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        view = null;
        mFetchMovies.dispose();
    }
}
