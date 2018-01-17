package com.esoxjem.movieguide.listing.sorting;

import com.esoxjem.movieguide.BasePresenter;

/**
 * @author arun
 */
public interface SortingDialogPresenter extends BasePresenter {
    void setLastSavedOption();

    void onPopularMoviesSelected();

    void onHighestRatedMoviesSelected();

    void onFavoritesSelected();

    void setView(SortingDialogView view);
}
