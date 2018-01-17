package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.MovieModel;
import com.esoxjem.movieguide.ReviewModel;
import com.esoxjem.movieguide.VideoModel;

import java.util.List;

/**
 * @author arun
 */
interface MovieDetailsView
{
    void showDetails(MovieModel movie);
    void showTrailers(List<VideoModel> trailers);
    void showReviews(List<ReviewModel> reviews);
    void showFavorited();
    void showUnFavorited();
}
