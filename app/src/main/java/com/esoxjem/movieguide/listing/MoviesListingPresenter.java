package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.BasePresenter;

/**
 * @author arun
 */
public interface MoviesListingPresenter extends BasePresenter {
    void displayMovies();

    void setView(MoviesListingView view);
}
