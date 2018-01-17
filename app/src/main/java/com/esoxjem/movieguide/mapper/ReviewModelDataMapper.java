/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esoxjem.movieguide.mapper;

import com.esoxjem.movieguide.ReviewModel;
import com.example.domain.Review;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class ReviewModelDataMapper {

    @Inject
    public ReviewModelDataMapper() {
    }

    public ReviewModel transform(Review review) {
        if (review == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final ReviewModel reviewModel = new ReviewModel();
        reviewModel.setId(review.getId());
        reviewModel.setAuthor(review.getAuthor());
        reviewModel.setContent(review.getContent());
        reviewModel.setUrl(review.getUrl());

        return reviewModel;
    }

    public List<ReviewModel> transform(Collection<Review> reviewCollection) {
        List<ReviewModel> reviewModelList;

        if (reviewCollection != null && !reviewCollection.isEmpty()) {
            reviewModelList = new ArrayList<>();
            for (Review review : reviewCollection) {
                reviewModelList.add(transform(review));
            }
        } else {
            reviewModelList = Collections.emptyList();
        }

        return reviewModelList;
    }
}
