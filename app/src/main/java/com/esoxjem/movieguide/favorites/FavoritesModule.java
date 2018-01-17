package com.esoxjem.movieguide.favorites;

import com.esoxjem.movieguide.AppModule;
import com.example.data.cache.FavoritesCache;
import com.example.data.cache.FavoritesCacheImpl;
import com.example.data.repository.MovieDataRepository;
import com.example.data.repository.datasource.RemoteMovieDataSource;
import com.example.data.repository.datasource.RemoteMovieDataSourceImpl;
import com.example.domain.interactor.FavoriteUseCase;
import com.example.domain.repository.MovieRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author pulkitkumar
 */
@Module(includes = AppModule.class)
public class FavoritesModule {

    @Provides
    @Singleton
    FavoritesCache provideFavoritesCache(FavoritesCacheImpl favoritesCache) {
        return favoritesCache;
    }

    @Provides
    @Singleton
    MovieRepository provideMovieRepository(MovieDataRepository repository) {
        return repository;
    }

    @Provides
    @Singleton
    FavoriteUseCase provideFavoriteUseCase(MovieRepository movieRepository) {
        return new FavoriteUseCase(movieRepository);
    }

    @Provides
    @Singleton
    RemoteMovieDataSource provideRemoteMovieDataSource(
            RemoteMovieDataSourceImpl remoteMovieDataSource) {
        return remoteMovieDataSource;
    }
}
