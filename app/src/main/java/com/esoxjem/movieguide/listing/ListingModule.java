package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.mapper.MovieModelDataMapper;
import com.esoxjem.movieguide.network.TmdbWebService;
import com.example.domain.interactor.FavoriteUseCase;
import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class ListingModule {
    @Provides
    MoviesListingInteractor provideMovieListingInteractor(FavoriteUseCase favoriteUseCase,
            TmdbWebService tmdbWebService, SortingOptionStore sortingOptionStore,
            MovieModelDataMapper dataMapper) {
        return new MoviesListingInteractorImpl(favoriteUseCase, tmdbWebService, sortingOptionStore,
                dataMapper);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {
        return new MoviesListingPresenterImpl(interactor);
    }
}
