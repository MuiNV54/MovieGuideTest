package com.esoxjem.movieguide.listing.sorting;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class SortingModule {

    @Provides
    SortingDialogPresenter providePresenter(SortingDialogPresenterImpl presenter) {
        return presenter;
    }
}
