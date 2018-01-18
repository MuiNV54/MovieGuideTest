package com.example.domain.interactor;

import com.example.domain.Movie;
import com.example.domain.SortType;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.MovieRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 18/01/2018.
 */

public class FetchMovies extends UseCase<List<Movie>, Void> {
    private MovieRepository mMovieRepository;

    @Inject
    public FetchMovies(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
            MovieRepository movieRepository) {
        super(threadExecutor, postExecutionThread);
        mMovieRepository = movieRepository;
    }

    @Override
    Observable<List<Movie>> buildUseCaseObservable(Void aVoid) {
        int selectedOption = mMovieRepository.getSelectedSortingOption();
        SortType sortType;
        if (selectedOption == SortType.MOST_POPULAR.getValue()) {
            sortType = SortType.MOST_POPULAR;
        } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
            sortType = SortType.HIGHEST_RATED;
        } else {
            sortType = SortType.FAVORITES;
        }

        return mMovieRepository.fetchMovies(sortType);
    }
}
