package com.example.data.network;

import com.example.data.response.MoviesResponse;
import com.example.data.response.ReviewsResponse;
import com.example.data.response.VideoResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TmdbWebService {

    @GET("3/discover/movie?language=en&sort_by=popularity.desc")
    Observable<MoviesResponse> popularMovies();

    @GET("3/discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc")
    Observable<MoviesResponse> highestRatedMovies();

    @GET("3/movie/{movieId}/videos")
    Observable<VideoResponse> trailers(@Path("movieId") String movieId);

    @GET("3/movie/{movieId}/reviews")
    Observable<ReviewsResponse> reviews(@Path("movieId") String movieId);
}
