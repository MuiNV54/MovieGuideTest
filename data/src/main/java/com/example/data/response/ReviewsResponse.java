package com.example.data.response;

import com.example.data.ReviewEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ivan on 8/20/2017.
 */

public class ReviewsResponse {

    @SerializedName("results")
    private List<ReviewEntity> reviews;

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }
}
