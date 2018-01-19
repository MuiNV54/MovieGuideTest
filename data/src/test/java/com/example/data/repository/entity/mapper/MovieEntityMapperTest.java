package com.example.data.repository.entity.mapper;

import com.example.data.entity.MovieEntity;
import com.example.data.entity.mapper.MovieEntityDataMapper;
import com.example.domain.Movie;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by nguyen.van.mui on 19/01/2018.
 */

public class MovieEntityMapperTest {
    private static final String MOVIE_ID = "123";
    private static String MOVIE_NAME = "test name";

    private MovieEntityDataMapper mEntityDataMapper;

    @Before
    public void setup() {
        mEntityDataMapper = new MovieEntityDataMapper();
    }

    @Test
    public void testTransformMovieEntity() {
        MovieEntity movieEntity = createFakeMovie();
        Movie movie = mEntityDataMapper.transform(movieEntity);

        assertThat(movie, is(instanceOf(Movie.class)));
        assertThat(movie.getId(), is(MOVIE_ID));
        assertThat(movie.getOverview(), is(MOVIE_NAME));
    }

    @Test
    public void testTransformMovieEntityCollection() {
        MovieEntity entity1 = mock(MovieEntity.class);
        MovieEntity entity2 = mock(MovieEntity.class);

        List<MovieEntity> entityList = new ArrayList<>();
        entityList.add(entity1);
        entityList.add(entity2);

        List<Movie> movieList = mEntityDataMapper.transform(entityList);

        assertThat(movieList.get(0), is(instanceOf(Movie.class)));
        assertThat(movieList.get(1), is(instanceOf(Movie.class)));
        assertThat(movieList.size(), is(2));
    }

    private MovieEntity createFakeMovie() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(MOVIE_ID);
        movieEntity.setOverview(MOVIE_NAME);

        return movieEntity;
    }
}
