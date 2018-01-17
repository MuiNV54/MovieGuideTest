package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.MovieModel;
import com.esoxjem.movieguide.MoviesWraper;
import com.esoxjem.movieguide.listing.sorting.SortType;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.mapper.MovieModelDataMapper;
import com.esoxjem.movieguide.network.TmdbWebService;
import com.example.domain.interactor.FavoriteUseCase;
import io.reactivex.Observable;
import java.util.List;

/**
 * @author arun
 */
class MoviesListingInteractorImpl implements MoviesListingInteractor {
    private FavoriteUseCase mFavoriteUseCase;
    private TmdbWebService tmdbWebService;
    private SortingOptionStore sortingOptionStore;
    private MovieModelDataMapper mModelDataMapper;

    MoviesListingInteractorImpl(FavoriteUseCase favoriteUseCase, TmdbWebService tmdbWebService,
            SortingOptionStore store, MovieModelDataMapper modelDataMapper) {
        this.mFavoriteUseCase = favoriteUseCase;
        this.tmdbWebService = tmdbWebService;
        sortingOptionStore = store;
        mModelDataMapper = modelDataMapper;
    }

    @Override
    public Observable<List<MovieModel>> fetchMovies() {
        int selectedOption = sortingOptionStore.getSelectedOption();
        if (selectedOption == SortType.MOST_POPULAR.getValue()) {
            return tmdbWebService.popularMovies().map(MoviesWraper::getMovieList);
        } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
            return tmdbWebService.highestRatedMovies().map(MoviesWraper::getMovieList);
        } else {
            return Observable.just(mModelDataMapper.transform(mFavoriteUseCase.getFavorites()));
        }
    }
}
