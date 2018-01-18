package com.esoxjem.movieguide.listing.sorting;

import com.example.domain.SortType;
import com.example.domain.interactor.SortingUseCase;
import javax.inject.Inject;

/**
 * @author arun
 */
class SortingDialogPresenterImpl implements SortingDialogPresenter {
    private SortingDialogView view;
    private SortingUseCase mSortingUseCase;

    @Inject
    public SortingDialogPresenterImpl(SortingUseCase sortingUseCase) {
        mSortingUseCase = sortingUseCase;
    }

    @Override
    public void setView(SortingDialogView view) {
        this.view = view;
    }

    @Override
    public void setLastSavedOption() {
        if (isViewAttached()) {
            int selectedOption = mSortingUseCase.getSelectedSortingOption();

            if (selectedOption == SortType.MOST_POPULAR.getValue()) {
                view.setPopularChecked();
            } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
                view.setHighestRatedChecked();
            } else {
                view.setFavoritesChecked();
            }
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void onPopularMoviesSelected() {
        if (isViewAttached()) {
            mSortingUseCase.setSortingOption(SortType.MOST_POPULAR);
            view.dismissDialog();
        }
    }

    @Override
    public void onHighestRatedMoviesSelected() {
        if (isViewAttached()) {
            mSortingUseCase.setSortingOption(SortType.HIGHEST_RATED);
            view.dismissDialog();
        }
    }

    @Override
    public void onFavoritesSelected() {
        if (isViewAttached()) {
            mSortingUseCase.setSortingOption(SortType.FAVORITES);
            view.dismissDialog();
        }
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
