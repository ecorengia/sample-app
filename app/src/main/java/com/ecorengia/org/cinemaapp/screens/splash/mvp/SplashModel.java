package com.ecorengia.org.cinemaapp.screens.splash.mvp;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.mvp.CinemaBaseModel;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.main.MainScreen;
import com.ecorengia.org.cinemaapp.screens.splash.SplashScreen;

public class SplashModel extends CinemaBaseModel<SplashScreen> {
    public SplashModel(@NonNull final SplashScreen splashScreen, @NonNull final CinemaApi cinemaApi) {
        super(splashScreen, cinemaApi);
    }

    /**
     * Swaps to main screen and finishes splash one.
     */
    public void swapToMainScreen() {
        final Intent intent = MainScreen.create(mScreen);
        mScreen.startActivity(intent);
        mScreen.finish();
    }
}
