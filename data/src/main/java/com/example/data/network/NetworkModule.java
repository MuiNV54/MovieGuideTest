package com.example.data.network;

import com.example.data.BuildConfig;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {
    public static final int CONNECT_TIMEOUT_IN_MS = 30000;

    Interceptor requestInterceptor(RequestInterceptor interceptor) {
        return interceptor;
    }

    OkHttpClient provideOkHttpClient(RequestInterceptor requestInterceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new okhttp3.OkHttpClient.Builder().connectTimeout(CONNECT_TIMEOUT_IN_MS,
                TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(requestInterceptor)
                .build();
    }

    Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(BuildConfig.TMDB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    TmdbWebService tmdbWebService(Retrofit retrofit) {
        return retrofit.create(TmdbWebService.class);
    }
}
