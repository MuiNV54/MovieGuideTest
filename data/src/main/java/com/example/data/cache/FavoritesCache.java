package com.example.data.cache;

import com.example.data.entity.MovieEntity;
import java.io.IOException;
import java.util.List;

/**
 * Created by nguyen.van.mui on 12/01/2018.
 */

public interface FavoritesCache {
    void setFavorite(MovieEntity movie);

    boolean isFavorite(String id);

    List<MovieEntity> getFavorites() throws IOException;

    void unFavorite(String id);
}
