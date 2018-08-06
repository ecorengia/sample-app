package com.ecorengia.org.cinemaapp.networking.factory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Cinema HTTP client factory.
 *
 * @author ecorengia
 */
public interface CinemaHttpFactory {

    /**
     * Initializes App client for network access.
     */
    OkHttpClient createClient(@NonNull final Context context, @Nullable final Interceptor[] interceptors);
}
