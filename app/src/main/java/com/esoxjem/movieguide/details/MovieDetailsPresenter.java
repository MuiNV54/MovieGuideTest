package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.BasePresenter;
import com.esoxjem.movieguide.MovieModel;

/**
 * @author arun
 */
public interface MovieDetailsPresenter extends BasePresenter
{
    void showDetails(MovieModel movie);

    void showTrailers(MovieModel movie);

    void showReviews(MovieModel movie);

    void showFavoriteButton(MovieModel movie);

    void onFavoriteClick(MovieModel movie);

    void setView(MovieDetailsView view);
}
