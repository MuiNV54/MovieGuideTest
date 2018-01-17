package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.network.TmdbWebService;
import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class DetailsModule {

    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsPresenterImpl presenter) {
        return presenter;
    }
}
