package com.ecorengia.org.cinemaapp.networking.factory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.ecorengia.org.cinemaapp.networking.ssl.CinemaTrustManager;
import com.ecorengia.org.cinemaapp.networking.ssl.SelfX509TrustManager;
import com.ecorengia.org.cinemaapp.utils.ArrayUtils;

import java.io.File;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Clients from this factory are designed to consume live (production ready) endpoints.
 *
 * @author ecorengia
 */
public final class LiveHttpFactory implements CinemaHttpFactory {

    private static final String CACHE_DIR = "httpCache";
    private static final int CACHE_SIZE = 15 * 1024 * 1024; // 15mb cache size

    private static final long CLIENT_TIMEOUT = 50;  // short timeout

    @Override
    public OkHttpClient createClient(@NonNull final Context context,
                                     @Nullable final Interceptor[] interceptors) {
        final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        // Configure SSL
        try {
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            final CinemaTrustManager trustManager = new SelfX509TrustManager();
            sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
            clientBuilder.sslSocketFactory(sslContext.getSocketFactory(), trustManager);
        } catch (@NonNull final NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            Timber.e(e, "Cannot initialize SSL Context: %s.", e.getLocalizedMessage());
        }

        // Configure timeouts
        clientBuilder.connectTimeout(CLIENT_TIMEOUT, TimeUnit.SECONDS);
        clientBuilder.readTimeout(CLIENT_TIMEOUT, TimeUnit.SECONDS);

        // Configure caching
        final File cacheDir = new File(context.getCacheDir(), CACHE_DIR);
        clientBuilder.cache(new Cache(cacheDir, CACHE_SIZE));

        // Configure interceptors
        if (!ArrayUtils.isEmpty(interceptors)) {
            clientBuilder.interceptors().addAll(java.util.Arrays.asList(interceptors));
        }
        // Add an interceptor to log all requests and responses
        // NOTE: This needs to be the last interceptor added, so other interceptors will execute first
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        clientBuilder.interceptors().add(loggingInterceptor);

        Timber.d("HTTP Client has been initialized.");
        return clientBuilder.build();
    }
}
