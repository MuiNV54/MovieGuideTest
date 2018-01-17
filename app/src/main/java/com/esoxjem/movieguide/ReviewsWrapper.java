package com.esoxjem.movieguide;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ivan on 8/20/2017.
 */

public class ReviewsWrapper {

    @SerializedName("results")
    private List<ReviewModel> reviews;

    public List<ReviewModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewModel> reviews) {
        this.reviews = reviews;
    }
}
