package com.example.data.response;

import com.example.data.entity.MovieEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ivan on 8/20/2017.
 */

public class MoviesResponse {

    @SerializedName("results")
    private List<MovieEntity> movies;

    public List<MovieEntity> getMovieList() {
        return movies;
    }

    public void setMovieList(List<MovieEntity> movieList) {
        this.movies = movieList;
    }
}
