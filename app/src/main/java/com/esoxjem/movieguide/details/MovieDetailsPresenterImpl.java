package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.MovieModel;
import com.esoxjem.movieguide.ReviewModel;
import com.esoxjem.movieguide.VideoModel;
import com.esoxjem.movieguide.mapper.MovieModelDataMapper;
import com.esoxjem.movieguide.mapper.ReviewModelDataMapper;
import com.esoxjem.movieguide.mapper.VideoModelDataMapper;
import com.example.domain.Review;
import com.example.domain.Video;
import com.example.domain.interactor.FavoriteUseCase;
import com.example.domain.interactor.GetReviews;
import com.example.domain.interactor.GetTrailers;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import javax.inject.Inject;

/**
 * @author arun
 */
class MovieDetailsPresenterImpl implements MovieDetailsPresenter {
    private MovieDetailsView view;
    private FavoriteUseCase mFavoriteUseCase;
    private MovieModelDataMapper mMovieModelDataMapper;
    private VideoModelDataMapper mVideoModelDataMapper;
    private ReviewModelDataMapper mReviewModelDataMapper;
    private GetTrailers mGetTrailers;
    private GetReviews mGetReviews;

    @Inject
    MovieDetailsPresenterImpl(FavoriteUseCase favoriteUseCase, MovieModelDataMapper modelDataMapper,
            GetTrailers getTrailers, VideoModelDataMapper videoModelDataMapper,
            GetReviews getReviews, ReviewModelDataMapper reviewModelDataMapper) {
        mFavoriteUseCase = favoriteUseCase;
        mMovieModelDataMapper = modelDataMapper;
        mGetTrailers = getTrailers;
        mVideoModelDataMapper = videoModelDataMapper;
        mGetReviews = getReviews;
        mReviewModelDataMapper = reviewModelDataMapper;
    }

    @Override
    public void setView(MovieDetailsView view) {
        this.view = view;
    }

    @Override
    public void showDetails(MovieModel movie) {
        if (isViewAttached()) {
            view.showDetails(movie);
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void showTrailers(MovieModel movie) {
        mGetTrailers.execute(new DisposableObserver<List<Video>>() {
            @Override
            public void onNext(List<Video> videos) {
                onGetTrailersSuccess(mVideoModelDataMapper.transform(videos));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, GetTrailers.Params.forUser(movie.getId()));
    }

    private void onGetTrailersSuccess(List<VideoModel> videos) {
        if (isViewAttached()) {
            view.showTrailers(videos);
        }
    }

    private void onGetTrailersFailure() {
        // Do nothing
    }

    @Override
    public void showReviews(MovieModel movie) {
        mGetReviews.execute(new DisposableObserver<List<Review>>() {
            @Override
            public void onNext(List<Review> reviews) {
                onGetReviewsSuccess(mReviewModelDataMapper.transform(reviews));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, movie.getId());
    }

    private void onGetReviewsSuccess(List<ReviewModel> reviews) {
        if (isViewAttached()) {
            view.showReviews(reviews);
        }
    }

    private void onGetReviewsFailure() {
        // Do nothing
    }

    @Override
    public void showFavoriteButton(MovieModel movie) {
        boolean isFavorite = mFavoriteUseCase.isFavorite(movie.getId());
        if (isViewAttached()) {
            if (isFavorite) {
                view.showFavorited();
            } else {
                view.showUnFavorited();
            }
        }
    }

    @Override
    public void onFavoriteClick(MovieModel movie) {
        if (isViewAttached()) {
            boolean isFavorite = mFavoriteUseCase.isFavorite(movie.getId());
            if (isFavorite) {
                mFavoriteUseCase.unFavorite(movie.getId());
                view.showUnFavorited();
            } else {
                mFavoriteUseCase.setFavorite(mMovieModelDataMapper.transformModel(movie));
                view.showFavorited();
            }
        }
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
        mGetTrailers.dispose();
        mGetReviews.dispose();
    }
}
