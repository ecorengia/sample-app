package com.ecorengia.org.cinemaapp.screens.details.mvp;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.data.model.MovieDetails;
import com.ecorengia.org.cinemaapp.mvp.CinemaBaseModel;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.details.DetailsScreen;

import timber.log.Timber;

public final class DetailsModel extends CinemaBaseModel<DetailsScreen> {
    public DetailsModel(@NonNull final DetailsScreen screen, @NonNull final CinemaApi cinemaApi) {
        super(screen, cinemaApi);
    }

    /**
     * Swaps to player screen for the provided {@code movieId}.
     */
    public void swapToVideoPlayer(final int movieId) {
        Timber.d("Switching to player screen for %d.", movieId);
//        final Intent detailsIntent = DetailsScreen.create(mScreen, movie.getId());
//        mScreen.startActivity(detailsIntent);
    }
}
