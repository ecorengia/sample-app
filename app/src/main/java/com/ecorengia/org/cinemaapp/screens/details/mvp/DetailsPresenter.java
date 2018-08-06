package com.ecorengia.org.cinemaapp.screens.details.mvp;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.data.model.MovieDetails;
import com.ecorengia.org.cinemaapp.mvp.MvpPresenter;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public final class DetailsPresenter implements MvpPresenter {
    @NonNull
    private final DetailsModel mModel;

    @NonNull
    private final DetailsView mView;

    @NonNull
    private final CompositeDisposable mDisposable;

    public DetailsPresenter(@NonNull final DetailsModel model, @NonNull final DetailsView view) {
        mModel = model;
        mView = view;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public final void onCreate() {
        // No-op
    }

    @Override
    public final void onDestroy() {
        mDisposable.clear();
    }

    @Override
    public final void onPause() {
        // No-op
    }

    @Override
    public final void onResume() {
        // No-op
    }

    /**
     * Queries movie details for the provided {@code movieId}.
     */
    public final void showDetails(final int movieId) {
        mDisposable.add(mModel.getMovieDetails(movieId)
                .subscribe(this::onDetailsLoaded, mView::onError));
    }

    /**
     * Respond to preview videos taps.
     */
    public void respondToPreview() {
        mDisposable.add(mView.previewClicks().subscribe(mModel::swapToVideoPlayer));
    }

    /**
     * Updates view with the details retrieved.
     */
    private void onDetailsLoaded(@NonNull final MovieDetails movieDetails) {
        Timber.d("Movie details have been loaded for %s.", movieDetails.getTitle());
        mView.bind(movieDetails);
    }
}
