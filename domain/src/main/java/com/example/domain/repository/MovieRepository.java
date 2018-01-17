package com.example.domain.repository;

import com.example.domain.Movie;
import com.example.domain.Review;
import com.example.domain.Video;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public interface MovieRepository {
    void setFavorite(Movie movie);

    boolean isFavorite(String id);

    List<Movie> getFavorites();

    void unFavorite(String id);

    Observable<List<Video>> getTrailers(String id);

    Observable<List<Review>> getReviews(String id);
}
