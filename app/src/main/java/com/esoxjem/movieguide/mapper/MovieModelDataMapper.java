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
package com.esoxjem.movieguide.mapper;

import com.esoxjem.movieguide.MovieModel;
import com.example.domain.Movie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class MovieModelDataMapper {

    @Inject
    public MovieModelDataMapper() {
    }

    public MovieModel transform(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final MovieModel movieModel = new MovieModel();
        movieModel.setId(movie.getId());
        movieModel.setOverview(movie.getOverview());
        movieModel.setBackdropPath(movie.getBackdropPath());
        movieModel.setReleaseDate(movie.getBackdropPath());
        movieModel.setTitle(movie.getTitle());
        movieModel.setVoteAverage(movie.getVoteAverage());
        movieModel.setPosterPath(movie.getPosterPath());

        return movieModel;
    }

    public List<MovieModel> transform(Collection<Movie> moviesCollection) {
        List<MovieModel> movieModelCollection;

        if (moviesCollection != null && !moviesCollection.isEmpty()) {
            movieModelCollection = new ArrayList<>();
            for (Movie movie : moviesCollection) {
                movieModelCollection.add(transform(movie));
            }
        } else {
            movieModelCollection = Collections.emptyList();
        }

        return movieModelCollection;
    }

    public Movie transformModel(MovieModel movieModel) {
        if (movieModel == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final Movie movie = new Movie();
        movie.setId(movieModel.getId());
        movie.setOverview(movieModel.getOverview());
        movie.setBackdropPath(movieModel.getBackdropPath());
        movie.setReleaseDate(movieModel.getBackdropPath());
        movie.setTitle(movieModel.getTitle());
        movie.setVoteAverage(movieModel.getVoteAverage());
        movie.setPosterPath(movieModel.getPosterPath());

        return movie;
    }

    public Collection<Movie> transformModel(Collection<MovieModel> movieModelCollection) {
        Collection<Movie> movieCollection;

        if (movieModelCollection != null && !movieModelCollection.isEmpty()) {
            movieCollection = new ArrayList<>();
            for (MovieModel movieModel : movieModelCollection) {
                movieCollection.add(transformModel(movieModel));
            }
        } else {
            movieCollection = Collections.emptyList();
        }

        return movieCollection;
    }
}
