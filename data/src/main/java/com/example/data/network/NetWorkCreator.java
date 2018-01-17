package com.example.data.network;

import com.example.data.BuildConfig;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkCreator {
    public static final int CONNECT_TIMEOUT_IN_MS = 30000;
    public static NetWorkCreator INSTANCE;

    public TmdbWebService mWebService;

    public static final NetWorkCreator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NetWorkCreator();
        }

        return INSTANCE;
    }

    public NetWorkCreator() {
        RequestInterceptor requestInterceptor = new RequestInterceptor();
        OkHttpClient okHttpClient = provideOkHttpClient(requestInterceptor);
        Retrofit retrofit = retrofit(okHttpClient);
        mWebService = retrofit.create(TmdbWebService.class);
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

    public static TmdbWebService tmdbWebService(Retrofit retrofit) {
        return retrofit.create(TmdbWebService.class);
    }
}
