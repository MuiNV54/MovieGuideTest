package com.example.data.repository;

import com.example.data.ReviewEntity;
import com.example.data.entity.mapper.MovieEntityDataMapper;
import com.example.data.entity.mapper.ReviewModelDataMapper;
import com.example.data.entity.mapper.VideoModelDataMapper;
import com.example.data.repository.datasource.DiskMovieDataSource;
import com.example.data.repository.datasource.MovieDataSourceFactory;
import com.example.data.repository.datasource.RemoteMovieDataSource;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by nguyen.van.mui on 19/01/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class MovieDataRepositoryTest {

    private MovieDataRepository mDataRepository;

    @Mock
    MovieDataSourceFactory mockMovieDataSourceFactory;
    @Mock
    MovieEntityDataMapper mockMovieEntityDataMapper;
    @Mock
    ReviewModelDataMapper mockReviewModelDataMapper;
    @Mock
    VideoModelDataMapper mockVideoModelDataMapper;
    @Mock
    DiskMovieDataSource mockDiskMovieDataSource;
    @Mock
    RemoteMovieDataSource mockRemoteMovieDataSource;

    @Before
    public void setup() {
        mDataRepository =
                new MovieDataRepository(mockMovieDataSourceFactory, mockMovieEntityDataMapper,
                        mockReviewModelDataMapper, mockVideoModelDataMapper,
                        mockMovieEntityDataMapper);
        given(mockMovieDataSourceFactory.createDiskDataSource()).willReturn(
                mockDiskMovieDataSource);
        given(mockMovieDataSourceFactory.createRemoteMovieDataSource()).willReturn(
                mockRemoteMovieDataSource);
    }

    @Test
    public void testGetReviews() {
        List<ReviewEntity> reviews = new ArrayList<>();
        reviews.add(new ReviewEntity());

        given(mockRemoteMovieDataSource.getReviews(anyString())).willReturn(
                Observable.just(reviews));
        mDataRepository.getReviews("123");

        verify(mockMovieDataSourceFactory).createRemoteMovieDataSource();
        verify(mockRemoteMovieDataSource).getReviews("123");
    }
}
