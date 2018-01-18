package com.example.data.repository;

import com.example.data.ReviewEntity;
import com.example.data.VideoEntity;
import com.example.data.entity.MovieEntity;
import com.example.data.entity.mapper.MovieEntityDataMapper;
import com.example.data.entity.mapper.ReviewModelDataMapper;
import com.example.data.entity.mapper.VideoModelDataMapper;
import com.example.data.repository.datasource.DiskMovieDataSource;
import com.example.data.repository.datasource.MovieDataSourceFactory;
import com.example.domain.Movie;
import com.example.domain.Review;
import com.example.domain.SortType;
import com.example.domain.Video;
import com.example.domain.repository.MovieRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public class MovieDataRepository implements MovieRepository {
    private MovieDataSourceFactory mSourceFactory;
    private MovieEntityDataMapper mEntityDataMapper;
    private ReviewModelDataMapper mReviewModelDataMapper;
    private VideoModelDataMapper mVideoModelDataMapper;
    private MovieEntityDataMapper mMovieEntityDataMapper;

    @Inject
    public MovieDataRepository(MovieDataSourceFactory sourceFactory,
            MovieEntityDataMapper entityDataMapper, ReviewModelDataMapper reviewModelDataMapper,
            VideoModelDataMapper videoModelDataMapper,
            MovieEntityDataMapper movieEntityDataMapper) {
        mSourceFactory = sourceFactory;
        mEntityDataMapper = entityDataMapper;
        mReviewModelDataMapper = reviewModelDataMapper;
        mVideoModelDataMapper = videoModelDataMapper;
        mMovieEntityDataMapper = movieEntityDataMapper;
    }

    @Override
    public void setFavorite(Movie movie) {
        final DiskMovieDataSource diskMovieDataSource = mSourceFactory.createDiskDataSource();
        diskMovieDataSource.setFavorite(mEntityDataMapper.transform(movie));
    }

    @Override
    public boolean isFavorite(String id) {
        final DiskMovieDataSource diskMovieDataSource = mSourceFactory.createDiskDataSource();
        return diskMovieDataSource.isFavorite(id);
    }

    @Override
    public List<Movie> getFavorites() {
        final DiskMovieDataSource diskMovieDataSource = mSourceFactory.createDiskDataSource();
        try {
            return mEntityDataMapper.transform(diskMovieDataSource.getFavorites());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void unFavorite(String id) {
        final DiskMovieDataSource diskMovieDataSource = mSourceFactory.createDiskDataSource();
        diskMovieDataSource.unFavorite(id);
    }

    @Override
    public Observable<List<Video>> getTrailers(String id) {
        return mSourceFactory.createRemoteMovieDataSource()
                .getTrailers(id)
                .map(new Function<List<VideoEntity>, List<Video>>() {
                    @Override
                    public List<Video> apply(List<VideoEntity> videoEntities) throws Exception {
                        return mVideoModelDataMapper.transform(videoEntities);
                    }
                });
    }

    @Override
    public Observable<List<Review>> getReviews(String id) {
        return mSourceFactory.createRemoteMovieDataSource()
                .getReviews(id)
                .map(new Function<List<ReviewEntity>, List<Review>>() {
                    @Override
                    public List<Review> apply(List<ReviewEntity> reviewEntities) throws Exception {
                        return mReviewModelDataMapper.transform(reviewEntities);
                    }
                });
    }

    @Override
    public Observable<List<Movie>> fetchMovies(SortType sortType) {
        if (sortType == SortType.FAVORITES) {
            try {
                return Observable.just(mMovieEntityDataMapper.transform(
                        mSourceFactory.createDiskDataSource().getFavorites()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mSourceFactory.createRemoteMovieDataSource()
                .fetchMovies(sortType)
                .map(new Function<List<MovieEntity>, List<Movie>>() {
                    @Override
                    public List<Movie> apply(List<MovieEntity> movieEntities) throws Exception {
                        return mMovieEntityDataMapper.transform(movieEntities);
                    }
                });
    }

    @Override
    public int getSelectedSortingOption() {
        return mSourceFactory.createDiskDataSource().getSelectedSortingOption();
    }

    @Override
    public void setSortingOption(SortType sortType) {
        mSourceFactory.createDiskDataSource().setSortingOption(sortType);
    }
}
