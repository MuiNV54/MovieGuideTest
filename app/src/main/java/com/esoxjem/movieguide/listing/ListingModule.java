package com.esoxjem.movieguide.listing;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class ListingModule {

    @Provides
    MoviesListingPresenter provideMoviesListingPresenter(MoviesListingPresenterImpl presenter) {
        return presenter;
    }
}
