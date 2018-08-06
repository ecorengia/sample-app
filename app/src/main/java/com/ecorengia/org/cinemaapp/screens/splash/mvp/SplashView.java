package com.ecorengia.org.cinemaapp.screens.splash.mvp;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.mvp.MvpView;
import com.ecorengia.org.cinemaapp.screens.splash.SplashScreen;

import timber.log.Timber;

/**
 * Splash view.
 *
 * @author ecorengia
 */
public final class SplashView implements MvpView {
    @NonNull
    private final View mView;

    public SplashView(@NonNull final SplashScreen activity) {
        // Set-up splash view
        final FrameLayout parent = new FrameLayout(activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mView = LayoutInflater.from(activity).inflate(R.layout.activity_splash, parent,
                true);
        activity.setContentView(mView);
    }

    @NonNull
    @Override
    public final View view() {
        return mView;
    }

    @Override
    public final void onError(@NonNull final Throwable e) {
        Timber.e(e);
        Toast.makeText(mView.getContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }
}
