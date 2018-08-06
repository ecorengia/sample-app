package com.ecorengia.org.cinemaapp.screens.player.di;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.app.ActivityScoped;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.player.PlayerScreen;
import com.ecorengia.org.cinemaapp.screens.player.mvp.PlayerModel;
import com.ecorengia.org.cinemaapp.screens.player.mvp.PlayerPresenter;
import com.ecorengia.org.cinemaapp.screens.player.mvp.PlayerView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Player screen dependencies.
 *
 * @author ecorengia
 */
@Module
public final class PlayerModule {
    @ActivityScoped
    @Provides
    static PlayerModel provideModel(@NonNull final PlayerScreen activity, @Named("CinemaApi") @NonNull final CinemaApi cinemaApi) {
        return new PlayerModel(activity, cinemaApi);
    }

    @ActivityScoped
    @Provides
    static PlayerView provideView(@NonNull final PlayerScreen activity) {
        return new PlayerView(activity);
    }

    @ActivityScoped
    @Provides
    static PlayerPresenter providePresenter(@NonNull final PlayerModel model, @NonNull final PlayerView view) {
        return new PlayerPresenter(model, view);
    }
}
