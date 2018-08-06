package com.ecorengia.org.cinemaapp.networking.interceptors;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Custom interceptor responsible for adding TMDb API key in the request.
 *
 * @author ecorengia
 */
public final class ApiKeyInterceptor implements Interceptor {

    private final static String API_KEY_PARAM = "api_key";

    @Override
    public Response intercept(@NonNull final Chain chain) throws IOException {
        final Request request = chain.request();
        // Add API key parameter in the URL
        final HttpUrl url = request.url().newBuilder()
                .addQueryParameter(API_KEY_PARAM, BuildConfig.TMDB_API_KEY)
                .build();
        // Proceed with the request
        return chain.proceed(request.newBuilder()
                .url(url)
                .build());
    }
}
