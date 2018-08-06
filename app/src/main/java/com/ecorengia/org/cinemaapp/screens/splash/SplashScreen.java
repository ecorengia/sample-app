package com.ecorengia.org.cinemaapp.screens.splash;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.screens.CinemaBaseActivity;
import com.ecorengia.org.cinemaapp.screens.splash.mvp.SplashPresenter;

/**
 * Splash screen.
 *
 * @author ecorengia
 */
public final class SplashScreen extends CinemaBaseActivity<SplashPresenter> {
    public static Intent create(@NonNull final Context context) {
        return new Intent(context, SplashScreen.class);
    }
}
