package com.ecorengia.org.cinemaapp.networking;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.app.CinemaApp;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.networking.factory.CinemaHttpFactory;
import com.ecorengia.org.cinemaapp.networking.factory.LiveHttpFactory;
import com.ecorengia.org.cinemaapp.networking.interceptors.ApiKeyInterceptor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Networking dependencies. All this dependencies are {@link Singleton} scoped.
 *
 * @author ecorengia
 */
@Module
public final class ApiModule {

    @NonNull
    @Singleton
    @Provides
    static OkHttpClient provideOkHttpClient(@NonNull final CinemaApp appContext) {
        final CinemaHttpFactory factory = new LiveHttpFactory();
        return factory.createClient(appContext, new Interceptor[]{new ApiKeyInterceptor()});
    }

    @NonNull
    @Singleton
    @Provides
    static Retrofit.Builder provideRetrofitBuilder(@Named("CinemaApiUrl") @NonNull final String baseUrl) {
        return new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }

    @NonNull
    @Singleton
    @Provides
    @Named("CinemaApi")
    static CinemaApi provideCinemaApi(@NonNull final Retrofit.Builder builder, @NonNull final OkHttpClient client) {
        return builder
                .client(client)
                .build()
                .create(CinemaApi.class);
    }
}
