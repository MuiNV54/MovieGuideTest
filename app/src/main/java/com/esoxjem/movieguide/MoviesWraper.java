package com.esoxjem.movieguide;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ivan on 8/20/2017.
 */

public class MoviesWraper {

    @SerializedName("results")
    private List<MovieModel> movies;

    public List<MovieModel> getMovieList() {
        return movies;
    }

    public void setMovieList(List<MovieModel> movieList) {
        this.movies = movieList;
    }
}
