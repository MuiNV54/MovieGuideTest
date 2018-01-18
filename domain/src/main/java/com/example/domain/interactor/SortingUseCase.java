package com.example.domain.interactor;

import com.example.domain.SortType;
import com.example.domain.repository.MovieRepository;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 18/01/2018.
 */

public class SortingUseCase {
    private final MovieRepository mMovieRepository;

    @Inject
    public SortingUseCase(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    public int getSelectedSortingOption() {
        return mMovieRepository.getSelectedSortingOption();
    }

    public void setSortingOption(SortType sortType) {
        mMovieRepository.setSortingOption(sortType);
    }
}
