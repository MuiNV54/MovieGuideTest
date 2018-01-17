package com.example.data.repository;

import com.example.data.entity.mapper.MovieEntityDataMapper;
import com.example.data.repository.datasource.DiskMovieDataSource;
import com.example.data.repository.datasource.MovieDataSourceFactory;
import com.example.domain.Movie;
import com.example.domain.repository.MovieRepository;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public class MovieDataRepository implements MovieRepository {
    private MovieDataSourceFactory mSourceFactory;
    private MovieEntityDataMapper mEntityDataMapper;

    @Inject
    public MovieDataRepository(MovieDataSourceFactory sourceFactory,
            MovieEntityDataMapper entityDataMapper) {
        mSourceFactory = sourceFactory;
        mEntityDataMapper = entityDataMapper;
    }

    @Override
    public void setFavorite(Movie movie) {
        final DiskMovieDataSource diskMovieDataSource = mSourceFactory.createDiskDataSource();
        diskMovieDataSource.setFavorite(mEntityDataMapper.transform(movie));
    }

    @Override
    public boolean isFavorite(String id) {
        final DiskMovieDataSource diskMovieDataSource = mSourceFactory.createDiskDataSource();
        return diskMovieDataSource.isFavorite(id);
    }

    @Override
    public List<Movie> getFavorites() {
        final DiskMovieDataSource diskMovieDataSource = mSourceFactory.createDiskDataSource();
        try {
            return mEntityDataMapper.transform(diskMovieDataSource.getFavorites());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void unFavorite(String id) {
        final DiskMovieDataSource diskMovieDataSource = mSourceFactory.createDiskDataSource();
        diskMovieDataSource.unFavorite(id);
    }
}
