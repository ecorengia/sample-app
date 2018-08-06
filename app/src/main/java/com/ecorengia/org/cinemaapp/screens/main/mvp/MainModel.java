package com.ecorengia.org.cinemaapp.screens.main.mvp;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.data.model.MovieListObject;
import com.ecorengia.org.cinemaapp.mvp.CinemaBaseModel;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.main.MainScreen;

import timber.log.Timber;

public final class MainModel extends CinemaBaseModel<MainScreen> {
    public MainModel(@NonNull final MainScreen screen, @NonNull final CinemaApi cinemaApi) {
        super(screen, cinemaApi);
    }

    /**
     * Swaps to movie details screen for the provided {@code movie}.
     */
    public void swapToMovieDetails(@NonNull final MovieListObject movie) {
        Timber.d("Switching to media details for %s.", movie.getTitle());   // TODO
    }
}
