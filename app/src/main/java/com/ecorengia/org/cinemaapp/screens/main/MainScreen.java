package com.ecorengia.org.cinemaapp.screens.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.screens.CinemaBaseActivity;
import com.ecorengia.org.cinemaapp.screens.main.mvp.MainPresenter;

/**
 * Main screen.
 *
 * @author ecorengia
 */
public final class MainScreen extends CinemaBaseActivity<MainPresenter> {
    public static Intent create(@NonNull final Context context) {
        return new Intent(context, MainScreen.class);
    }
}
