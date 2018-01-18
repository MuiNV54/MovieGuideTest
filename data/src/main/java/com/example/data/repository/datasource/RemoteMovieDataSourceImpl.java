package com.example.data.repository.datasource;

import com.example.data.ReviewEntity;
import com.example.data.VideoEntity;
import com.example.data.entity.MovieEntity;
import com.example.data.network.TmdbWebService;
import com.example.data.response.MoviesResponse;
import com.example.data.response.ReviewsResponse;
import com.example.data.response.VideoResponse;
import com.example.domain.SortType;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 17/01/2018.
 */

public class RemoteMovieDataSourceImpl implements RemoteMovieDataSource {
    private TmdbWebService mWebService;

    @Inject
    public RemoteMovieDataSourceImpl(TmdbWebService webService) {
        mWebService = webService;
    }

    @Override
    public Observable<List<VideoEntity>> getTrailers(String id) {
        return mWebService.trailers(id).map(new Function<VideoResponse, List<VideoEntity>>() {
            @Override
            public List<VideoEntity> apply(VideoResponse videoResponse) throws Exception {
                return videoResponse.getVideos();
            }
        });
    }

    @Override
    public Observable<List<ReviewEntity>> getReviews(String id) {
        return mWebService.reviews(id).map(new Function<ReviewsResponse, List<ReviewEntity>>() {
            @Override
            public List<ReviewEntity> apply(ReviewsResponse reviewsResponse) throws Exception {
                return reviewsResponse.getReviews();
            }
        });
    }

    @Override
    public Observable<List<MovieEntity>> fetchMovies(SortType sortType) {
        if (sortType == SortType.MOST_POPULAR) {
            return mWebService.popularMovies()
                    .map(new Function<MoviesResponse, List<MovieEntity>>() {
                        @Override
                        public List<MovieEntity> apply(MoviesResponse moviesResponse)
                                throws Exception {
                            return moviesResponse.getMovieList();
                        }
                    });
        } else {
            return mWebService.highestRatedMovies()
                    .map(new Function<MoviesResponse, List<MovieEntity>>() {
                        @Override
                        public List<MovieEntity> apply(MoviesResponse moviesResponse)
                                throws Exception {
                            return moviesResponse.getMovieList();
                        }
                    });
        }
    }
}
