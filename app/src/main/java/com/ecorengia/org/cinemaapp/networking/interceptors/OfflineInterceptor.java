package com.ecorengia.org.cinemaapp.networking.interceptors;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Interceptor on charge of returning cached content when user is offline.
 * TODO: Use AACs instead for caching objects (Room + LiveData).
 */
public final class OfflineInterceptor implements Interceptor {
    @NonNull
    private final Context mContext;

    public OfflineInterceptor(@NonNull final Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(@NonNull final Chain chain) throws IOException {
        final Response originalResponse = chain.proceed(chain.request());
        if (!NetworkUtils.isNetworkAvailable(mContext)) {
            final int maxAge = 60 * 60 * 24 * 7;    // 1 week
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-age=" + maxAge)
                    .build();
        } else {
            return originalResponse;
        }

    }
}
