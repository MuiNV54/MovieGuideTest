package com.example.data.repository.entity.mapper;

import com.example.data.ReviewEntity;
import com.example.data.entity.MovieEntity;
import com.example.data.entity.mapper.MovieEntityDataMapper;
import com.example.data.entity.mapper.ReviewModelDataMapper;
import com.example.domain.Movie;
import com.example.domain.Review;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by nguyen.van.mui on 19/01/2018.
 */

public class ReviewEntityMapperTest {
    private static final String REVIEW_ID = "123";
    private static String REVIEW_NAME = "test name";

    private ReviewModelDataMapper mEntityDataMapper;

    @Before
    public void setup() {
        mEntityDataMapper = new ReviewModelDataMapper();
    }

    @Test
    public void testTransformReviewEntity() {
        ReviewEntity reviewEntity = createFakeReview();
        Review review = mEntityDataMapper.transform(reviewEntity);

        assertThat(review, is(instanceOf(Movie.class)));
        assertThat(review.getId(), is(REVIEW_ID));
        assertThat(review.getAuthor(), is(REVIEW_NAME));
    }

    @Test
    public void testTransformReviewEntityCollection() {
        ReviewEntity entity1 = mock(ReviewEntity.class);
        ReviewEntity entity2 = mock(ReviewEntity.class);

        List<ReviewEntity> entityList = new ArrayList<>();
        entityList.add(entity1);
        entityList.add(entity2);

        List<Review> reviewList = mEntityDataMapper.transform(entityList);

        assertThat(reviewList.get(0), is(instanceOf(Review.class)));
        assertThat(reviewList.get(1), is(instanceOf(Review.class)));
        assertThat(reviewList.size(), is(2));
    }

    private ReviewEntity createFakeReview() {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setId(REVIEW_ID);
        reviewEntity.setAuthor(REVIEW_NAME);

        return reviewEntity;
    }
}
