package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.MovieModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
public interface MoviesListingInteractor
{
    Observable<List<MovieModel>> fetchMovies();
}
