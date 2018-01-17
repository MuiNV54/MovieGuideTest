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
package com.example.data.entity.mapper;

import com.example.data.ReviewEntity;
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

    public Review transform(ReviewEntity reviewEntity) {
        if (reviewEntity == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final Review review = new Review();
        review.setId(reviewEntity.getId());
        review.setAuthor(reviewEntity.getAuthor());
        review.setContent(reviewEntity.getContent());
        review.setUrl(reviewEntity.getUrl());

        return review;
    }

    public List<Review> transform(Collection<ReviewEntity> reviewEntities) {
        List<Review> reviewList;

        if (reviewEntities != null && !reviewEntities.isEmpty()) {
            reviewList = new ArrayList<>();
            for (ReviewEntity review : reviewEntities) {
                reviewList.add(transform(review));
            }
        } else {
            reviewList = Collections.emptyList();
        }

        return reviewList;
    }
}
