package com.ecorengia.org.cinemaapp.screens.player;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.screens.CinemaBaseActivity;
import com.ecorengia.org.cinemaapp.screens.player.mvp.PlayerPresenter;

import timber.log.Timber;

/**
 * Preview player screen.
 *
 * @author ecorengia
 */
public final class PlayerScreen extends CinemaBaseActivity<PlayerPresenter> {
    private static final String MOVIE_ID = "movie_id";

    public static Intent create(@NonNull final Context context, final int movieId) {
        return new Intent(context, PlayerScreen.class)
                .putExtra(MOVIE_ID, movieId);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Read source feed to show details
        final int movieId = getIntent().getIntExtra(MOVIE_ID, -1);
        if (movieId < 0) {
            Timber.e("Source media feed is not defined.");
            Toast.makeText(getApplicationContext(), R.string.err_no_media, Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // Load movie preview video
        if (mPresenter != null) {
            mPresenter.setMovieId(movieId);
        } else {
            Timber.e("Presenter has not been set.");
        }
    }
}
