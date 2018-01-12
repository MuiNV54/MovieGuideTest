package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.MovieModel;
import com.esoxjem.movieguide.Review;
import com.esoxjem.movieguide.Video;

import java.util.List;

/**
 * @author arun
 */
interface MovieDetailsView
{
    void showDetails(MovieModel movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();
}
