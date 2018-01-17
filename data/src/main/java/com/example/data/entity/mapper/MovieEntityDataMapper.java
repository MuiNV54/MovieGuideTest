/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.data.entity.mapper;

import com.example.data.entity.MovieEntity;
import com.example.domain.Movie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

public class MovieEntityDataMapper {

    @Inject
    public MovieEntityDataMapper() {
    }

    public Movie transform(MovieEntity userEntity) {
        Movie movie = null;
        movie = new Movie();
        movie.setId(userEntity.getId());
        movie.setOverview(userEntity.getOverview());
        movie.setBackdropPath(userEntity.getBackdropPath());
        movie.setReleaseDate(userEntity.getBackdropPath());
        movie.setTitle(userEntity.getTitle());
        movie.setVoteAverage(userEntity.getVoteAverage());
        movie.setPosterPath(userEntity.getPosterPath());

        return movie;
    }

    /**
     * Transform a List of {@link MovieEntity} into a Collection of {@link Movie}.
     *
     * @param movieEntityCollection Object Collection to be transformed.
     * @return {@link Movie} if valid {@link MovieEntity} otherwise null.
     */
    public List<Movie> transform(Collection<MovieEntity> movieEntityCollection) {
        final List<Movie> movieList = new ArrayList<>(20);
        for (MovieEntity movieEntity : movieEntityCollection) {
            final Movie movie = transform(movieEntity);
            if (movie != null) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

    public MovieEntity transform(Movie movie) {
        MovieEntity movieEntity = null;
        movieEntity = new MovieEntity();
        movieEntity.setId(movie.getId());
        movieEntity.setOverview(movie.getOverview());
        movieEntity.setBackdropPath(movie.getBackdropPath());
        movieEntity.setReleaseDate(movie.getBackdropPath());
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setVoteAverage(movie.getVoteAverage());
        movieEntity.setPosterPath(movie.getPosterPath());

        return movieEntity;
    }

    /**
     * Transform a List of {@link MovieEntity} into a Collection of {@link Movie}.
     *
     * @param movieCollection Object Collection to be transformed.
     * @return {@link Movie} if valid {@link MovieEntity} otherwise null.
     */
    public List<MovieEntity> transformToEntity(Collection<Movie> movieCollection) {
        final List<MovieEntity> movieEntities = new ArrayList<>(20);
        for (Movie movie : movieCollection) {
            final MovieEntity movieEntity = transform(movie);
            if (movieEntity != null) {
                movieEntities.add(movieEntity);
            }
        }
        return movieEntities;
    }
}
