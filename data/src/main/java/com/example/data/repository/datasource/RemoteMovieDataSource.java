package com.example.data.repository.datasource;

import com.example.data.ReviewEntity;
import com.example.data.VideoEntity;
import com.example.data.entity.MovieEntity;
import com.example.domain.Review;
import com.example.domain.SortType;
import com.example.domain.Video;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by nguyen.van.mui on 17/01/2018.
 */

public interface RemoteMovieDataSource {
    Observable<List<VideoEntity>> getTrailers(String id);

    Observable<List<ReviewEntity>> getReviews(String id);

    Observable<List<MovieEntity>> fetchMovies(SortType sortType);
}
