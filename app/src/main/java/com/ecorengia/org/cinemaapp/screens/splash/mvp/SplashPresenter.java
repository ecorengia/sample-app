package com.ecorengia.org.cinemaapp.screens.splash.mvp;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.mvp.MvpPresenter;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class SplashPresenter implements MvpPresenter {
    @NonNull
    private final SplashModel mModel;

    @NonNull
    private final SplashView mView;

    @NonNull
    private final CompositeDisposable mDisposable;

    public SplashPresenter(@NonNull final SplashModel model, @NonNull final SplashView view) {
        mModel = model;
        mView = view;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void onCreate() {
        // Call popular, top rated and now playing endpoints in order to cache them
        mDisposable.add(Single.concat(mModel.getPopular(1), mModel.getTopRated(1), mModel.getNowPlaying(1))
                .subscribe(searchResult -> Timber.d("Received partial result"),
                        mView::onError,
                        mModel::swapToMainScreen));
    }

    @Override
    public void onDestroy() {
        mDisposable.clear();
    }

    @Override
    public void onPause() {
        // No-op
    }

    @Override
    public void onResume() {
        // No-op
    }
}
