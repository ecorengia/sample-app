package com.ecorengia.org.cinemaapp.screens;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.ecorengia.org.cinemaapp.mvp.MvpPresenter;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import timber.log.Timber;

/**
 * Base class for every {@link android.app.Activity} in this application.
 *
 * @param <P> The {@link MvpPresenter} associated to this activity.
 * @author ecorengia
 */
public abstract class CinemaBaseActivity<P extends MvpPresenter> extends DaggerAppCompatActivity {

    @Inject
    @Nullable
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("Lifecycle. Activity %s -> onCreate.", getClass().getSimpleName());
        // Notify presenter about create event
        if (mPresenter != null) {
            mPresenter.onCreate();
        }
    }

    @Override
    protected void onDestroy() {
        Timber.d("Lifecycle. Activity %s -> onDestroy.", getClass().getSimpleName());
        // Notify model about destroy event
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Timber.d("Lifecycle. Activity %s -> onPause.", getClass().getSimpleName());
        // Notify presenter about pause event
        if (mPresenter != null) {
            mPresenter.onPause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("Lifecycle. Activity %s -> onResume.", getClass().getSimpleName());
        // Notify presenter about resume event
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull final Configuration newConfig) {
        Timber.d("Lifecycle. Activity %s -> onConfigurationChanged.", getClass().getSimpleName());
        super.onConfigurationChanged(newConfig);
    }

    /**
     * Replaces whatever is in container view with the given {@link Fragment}.
     */
    public final void replaceFragment(@NonNull final Fragment newFragment, @IdRes final int container, final boolean addToBackStage) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, newFragment);
        if (addToBackStage) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    /**
     * @return The {@link MvpPresenter} associated to this activity.
     */
    @Nullable
    public final P getPresenter() {
        return mPresenter;
    }
}
