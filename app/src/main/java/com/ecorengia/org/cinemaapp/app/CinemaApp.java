package com.ecorengia.org.cinemaapp.app;

import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ecorengia.org.cinemaapp.BuildConfig;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;

/**
 * Cinema app. Customizes app settings and establishes its dependencies.
 *
 * @author ecorengia
 */
public class CinemaApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends CinemaApp> applicationInjector() {
        return DaggerCinemaAppComponent.builder()
                .cinemaApiUrl(BuildConfig.TMDB_BASE_URL)
                .application(this)
                .build();
    }

    @Override
    public final void onCreate() {
        super.onCreate();

        // Setup logging
        initLogger();

        // Make sure we are always running latest security provider
        try {
            ProviderInstaller.installIfNeeded(this);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            // Ignore by now
        }

        // Enable Strict Mode on debug mode
        if (BuildConfig.DEBUG) {
            enableStrictMode();
        }
    }

    /**
     * Enables strict mode to make sure our app is behaving ok.
     */
    private void enableStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDialog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());
    }

    /**
     * Customizes app logging by making it more verbose on debug mode.
     */
    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected void log(final int priority, final String tag,
                                   @NonNull final String message, final Throwable t) {
                    if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
                        // In release mode avoid logging of messages with low priority
                        return;
                    }
                    super.log(priority, tag, message, t);
                }
            });
        }
    }
}
