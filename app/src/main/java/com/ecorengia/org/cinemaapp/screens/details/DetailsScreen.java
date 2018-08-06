package com.ecorengia.org.cinemaapp.screens.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.screens.CinemaBaseActivity;
import com.ecorengia.org.cinemaapp.screens.details.mvp.DetailsPresenter;

import timber.log.Timber;

/**
 * Movie details screen.
 *
 * @author ecorengia
 */
public final class DetailsScreen extends CinemaBaseActivity<DetailsPresenter> {
    private static final String MOVIE_ID = "movie_id";

    public static Intent create(@NonNull final Context context, final int movieId) {
        return new Intent(context, DetailsScreen.class)
                .putExtra(MOVIE_ID, movieId);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Read source feed to show details
        final int movieId = getIntent().getIntExtra(MOVIE_ID, -1);
        if (movieId < 0) {
            Timber.e("Source media feed is not defined.");
            Toast.makeText(getApplicationContext(), R.string.err_no_media,
                    Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // Load movie details
        if (mPresenter != null) {
            mPresenter.showDetails(movieId);
            mPresenter.respondToPreview();
        } else {
            Timber.e("Presenter has not been set.");
        }
    }
}
