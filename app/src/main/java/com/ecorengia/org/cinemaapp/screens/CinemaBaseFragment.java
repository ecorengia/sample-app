package com.ecorengia.org.cinemaapp.screens;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecorengia.org.cinemaapp.mvp.MvpPresenter;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import timber.log.Timber;

/**
 * Base class for every {@link android.app.Fragment} in this application.
 *
 * @param <P> The {@link MvpPresenter} associated to this fragment.
 * @author ecorengia
 */
public abstract class CinemaBaseFragment<P extends MvpPresenter> extends DaggerFragment {

    @Inject
    @Nullable
    protected P mPresenter;

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        Timber.d("Lifecycle. Fragment %s -> onCreateView.", getClass().getSimpleName());
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onAttach(final Context context) {
        Timber.d("Lifecycle. Fragment %s -> onAttach.", getClass().getSimpleName());
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        Timber.d("Lifecycle. Fragment %s -> onDetach.", getClass().getSimpleName());
        super.onDetach();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        Timber.d("Lifecycle. Fragment %s -> onCreate.", getClass().getSimpleName());
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        Timber.d("Lifecycle. Fragment %s -> onDestroy.", getClass().getSimpleName());
        super.onDestroy();
    }

    @Override
    public void onPause() {
        Timber.d("Lifecycle. Fragment %s -> onPause.", getClass().getSimpleName());
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.d("Lifecycle. Fragment %s -> onResume.", getClass().getSimpleName());
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Timber.d("Lifecycle. Fragment %s -> onConfigurationChanged.", getClass().getSimpleName());
    }

    /**
     * @return The {@link LayoutRes} associated to this fragment.
     */
    @LayoutRes
    protected abstract int getLayout();

    /**
     * @return The {@link MvpPresenter} associated to this fragment.
     */
    @Nullable
    public P getPresenter() {
        return mPresenter;
    }
}
