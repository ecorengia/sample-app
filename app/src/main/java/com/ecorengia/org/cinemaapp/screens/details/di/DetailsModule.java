package com.ecorengia.org.cinemaapp.screens.details.di;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.app.ActivityScoped;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.details.DetailsScreen;
import com.ecorengia.org.cinemaapp.screens.details.mvp.DetailsModel;
import com.ecorengia.org.cinemaapp.screens.details.mvp.DetailsPresenter;
import com.ecorengia.org.cinemaapp.screens.details.mvp.DetailsView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Details screen dependencies.
 *
 * @author ecorengia
 */
@Module
public final class DetailsModule {
    @ActivityScoped
    @Provides
    static DetailsModel provideModel(@NonNull final DetailsScreen activity, @Named("CinemaApi") @NonNull final CinemaApi cinemaApi) {
        return new DetailsModel(activity, cinemaApi);
    }

    @ActivityScoped
    @Provides
    static DetailsView provideView(@NonNull final DetailsScreen activity) {
        return new DetailsView(activity);
    }

    @ActivityScoped
    @Provides
    static DetailsPresenter providePresenter(@NonNull final DetailsModel model, @NonNull final DetailsView view) {
        return new DetailsPresenter(model, view);
    }
}
