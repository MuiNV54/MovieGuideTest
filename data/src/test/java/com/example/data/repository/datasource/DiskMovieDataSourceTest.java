package com.example.data.repository.datasource;

import com.example.data.cache.FavoritesCache;
import com.example.data.cache.SortingOptionStore;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by nguyen.van.mui on 19/01/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class DiskMovieDataSourceTest {
    private DiskMovieDataSource mDiskMovieDataSource;

    @Mock
    FavoritesCache mockFavoritesCache;
    @Mock
    SortingOptionStore mockSortingOptionStore;

    @Before
    public void setup() {
        mDiskMovieDataSource =
                new DiskMovieDataSourceImpl(mockFavoritesCache, mockSortingOptionStore);
    }

    @Test
    public void testGetFavorites() throws IOException {
        mDiskMovieDataSource.getFavorites();
        verify(mockFavoritesCache).getFavorites();
    }

    @Test
    public void testGetSelectedSortingOption() {
        mDiskMovieDataSource.getSelectedSortingOption();
        verify(mockSortingOptionStore).getSelectedOption();
    }
}
