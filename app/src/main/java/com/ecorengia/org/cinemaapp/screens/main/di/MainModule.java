package com.ecorengia.org.cinemaapp.screens.main.di;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.app.ActivityScoped;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.main.MainScreen;
import com.ecorengia.org.cinemaapp.screens.main.mvp.MainModel;
import com.ecorengia.org.cinemaapp.screens.main.mvp.MainPresenter;
import com.ecorengia.org.cinemaapp.screens.main.mvp.MainView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Main screen dependencies.
 *
 * @author ecorengia
 */
@Module
public final class MainModule {
    @ActivityScoped
    @Provides
    static MainModel provideModel(@NonNull final MainScreen activity, @Named("CinemaApi") @NonNull final CinemaApi cinemaApi) {
        return new MainModel(activity, cinemaApi);
    }

    @ActivityScoped
    @Provides
    static MainView provideView(@NonNull final MainScreen activity) {
        return new MainView(activity);
    }

    @ActivityScoped
    @Provides
    static MainPresenter providePresenter(@NonNull final MainModel model, @NonNull final MainView view) {
        return new MainPresenter(model, view);
    }
}
