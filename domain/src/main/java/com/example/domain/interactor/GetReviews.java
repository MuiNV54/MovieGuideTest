package com.example.domain.interactor;

import com.example.domain.Review;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.MovieRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 17/01/2018.
 */

public class GetReviews extends UseCase<List<Review>, String> {
    private final MovieRepository mMovieRepository;

    @Inject
    public GetReviews(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
            MovieRepository movieRepository) {
        super(threadExecutor, postExecutionThread);
        mMovieRepository = movieRepository;
    }

    @Override
    Observable<List<Review>> buildUseCaseObservable(String id) {
        return mMovieRepository.getReviews(id);
    }
}
