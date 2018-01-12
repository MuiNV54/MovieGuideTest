package com.example.data.network;

import com.example.data.response.MoviesResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TmdbWebService {

    @GET("3/discover/movie?language=en&sort_by=popularity.desc")
    Observable<MoviesResponse> popularMovies();

    @GET("3/discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc")
    Observable<MoviesResponse> highestRatedMovies();

    @GET("3/movie/{movieId}/videos")
    Observable<MoviesResponse> trailers(@Path("movieId") String movieId);

    @GET("3/movie/{movieId}/reviews")
    Observable<MoviesResponse> reviews(@Path("movieId") String movieId);
}
