package com.ecorengia.org.cinemaapp.screens.splash.di;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.app.ActivityScoped;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.splash.SplashScreen;
import com.ecorengia.org.cinemaapp.screens.splash.mvp.SplashModel;
import com.ecorengia.org.cinemaapp.screens.splash.mvp.SplashPresenter;
import com.ecorengia.org.cinemaapp.screens.splash.mvp.SplashView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Splash screen dependencies.
 *
 * @author ecorengia
 */
@Module
public final class SplashModule {
    @ActivityScoped
    @Provides
    static SplashModel provideModel(@NonNull final SplashScreen activity, @Named("CinemaApi") @NonNull final CinemaApi cinemaApi) {
        return new SplashModel(activity, cinemaApi);
    }

    @ActivityScoped
    @Provides
    static SplashView provideView(@NonNull final SplashScreen activity) {
        return new SplashView(activity);
    }

    @ActivityScoped
    @Provides
    static SplashPresenter providePresenter(@NonNull final SplashModel model, @NonNull final SplashView view) {
        return new SplashPresenter(model, view);
    }
}
