package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.MovieModel;

import java.util.List;

/**
 * @author arun
 */
interface MoviesListingView
{
    void showMovies(List<MovieModel> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onMovieClicked(MovieModel movie);
}
