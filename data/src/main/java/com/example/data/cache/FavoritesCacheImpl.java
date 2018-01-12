package com.example.data.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.example.data.entity.MovieEntity;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author arun
 */
public class FavoritesCacheImpl implements FavoritesCache {

    private static final String PREF_NAME = "FavoritesCacheImpl";
    private SharedPreferences pref;

    public FavoritesCacheImpl(Context context) {
        pref = context.getApplicationContext()
                .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setFavorite(MovieEntity movie) {
        SharedPreferences.Editor editor = pref.edit();
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<MovieEntity> jsonAdapter = moshi.adapter(MovieEntity.class);
        String movieJson = jsonAdapter.toJson(movie);
        editor.putString(movie.getId(), movieJson);
        editor.apply();
    }

    public boolean isFavorite(String id) {
        String movieJson = pref.getString(id, null);

        if (!TextUtils.isEmpty(movieJson)) {
            return true;
        } else {
            return false;
        }
    }

    public List<MovieEntity> getFavorites() throws IOException {
        Map<String, ?> allEntries = pref.getAll();
        ArrayList<MovieEntity> movies = new ArrayList<>(24);
        Moshi moshi = new Moshi.Builder().build();

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String movieJson = pref.getString(entry.getKey(), null);

            if (!TextUtils.isEmpty(movieJson)) {
                JsonAdapter<MovieEntity> jsonAdapter = moshi.adapter(MovieEntity.class);

                MovieEntity movie = jsonAdapter.fromJson(movieJson);
                movies.add(movie);
            } else {
                // Do nothing;
            }
        }
        return movies;
    }

    public void unFavorite(String id) {
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(id);
        editor.apply();
    }
}
