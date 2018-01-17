package com.example.domain.interactor;

import com.example.domain.Video;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.MovieRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 17/01/2018.
 */

public class GetTrailers extends UseCase<List<Video>, GetTrailers.Params> {

    private final MovieRepository mMovieRepository;

    @Inject
    public GetTrailers(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
            MovieRepository movieRepository) {
        super(threadExecutor, postExecutionThread);
        mMovieRepository = movieRepository;
    }

    @Override
    Observable<List<Video>> buildUseCaseObservable(Params params) {
        return mMovieRepository.getTrailers(params.id);
    }

    public static final class Params {

        private final String id;

        private Params(String userId) {
            this.id = userId;
        }

        public static Params forUser(String userId) {
            return new Params(userId);
        }
    }
}
