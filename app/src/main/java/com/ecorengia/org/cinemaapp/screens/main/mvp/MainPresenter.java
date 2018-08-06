package com.ecorengia.org.cinemaapp.screens.main.mvp;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.data.model.MovieListObject;
import com.ecorengia.org.cinemaapp.data.model.SearchResult;
import com.ecorengia.org.cinemaapp.mvp.MvpPresenter;
import com.ecorengia.org.cinemaapp.screens.main.MediaSection;
import com.ecorengia.org.cinemaapp.screens.main.tabs.MainTabFragment;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public final class MainPresenter implements MvpPresenter {
    private final static int MAX_PAGES = 15;

    private final Map<MediaSection, Integer> mCurrentPages = new HashMap<>(MediaSection.values().length);

    @NonNull
    private final MainModel mModel;

    @NonNull
    private final MainView mView;

    @NonNull
    private final CompositeDisposable mDisposable;

    public MainPresenter(@NonNull final MainModel model, @NonNull final MainView view) {
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
     * Swaps to movie details when user clicks on details section.
     */
    public final void respondToClick(@NonNull final MainTabFragment mainTabFragment) {
        mDisposable.add(mainTabFragment.itemClicks().subscribe(mModel::swapToMovieDetails));
    }

    /**
     * Loads more items when user is near the end of media list.
     */
    public final void respondToPagination(@NonNull final MainTabFragment mainTabFragment,
                                          @NonNull final MediaSection section) {
        mDisposable.add(mainTabFragment.userScrolls()
                .distinctUntilChanged() // Avoid repeated scroll events
                .filter(needMoreItems -> needMoreItems) // Filter events that are not close the end
                .take(MAX_PAGES - 1)    // Complete when we reach the max number of pages
                .map(n -> { // Read current page for this section
                    if (mCurrentPages.containsKey(section)) {
                        return mCurrentPages.get(section);
                    }
                    // Plus one, we are always coming from first page
                    return 2;
                })
                .subscribe(currentPage -> {
                    // Load page and update page counter
                    mainTabFragment.showMediaLoading(true);
                    loadContent(mainTabFragment, section, currentPage);
                    mCurrentPages.put(section, currentPage + 1);
                }));
    }

    /**
     * Loads content for the given {@code section}.
     */
    public final void loadContent(@NonNull final MainTabFragment mainTabFragment, @NonNull final MediaSection section) {
        loadContent(mainTabFragment, section, 1);
    }

    /**
     * Loads content for the given {@code section} for page {@code page}.
     */
    private void loadContent(@NonNull final MainTabFragment mainTabFragment, @NonNull final MediaSection section, final int page) {
        switch (section) {
            case TOP_RATED:
                mDisposable.add(mModel.getTopRated(page)
                        .subscribe(result -> onDataLoaded(mainTabFragment, result), t -> onLoadError(mainTabFragment, t)));
                return;
            case POPULAR:
                mDisposable.add(mModel.getPopular(page)
                        .subscribe(result -> onDataLoaded(mainTabFragment, result), t -> onLoadError(mainTabFragment, t)));
                return;
            case NOW_PLAYING:
                mDisposable.add(mModel.getNowPlaying(page)
                        .subscribe(result -> onDataLoaded(mainTabFragment, result), t -> onLoadError(mainTabFragment, t)));
                return;
            default:
                Timber.w("Media section is unknown.");
        }
    }

    /**
     * Updates media list by adding the results from {@code searchResults}.
     */
    private void onDataLoaded(@NonNull final MainTabFragment mainTabFragment, @NonNull final SearchResult searchResults) {
        final List<MovieListObject> videos = searchResults.getResults() != null ? searchResults.getResults() : Collections.emptyList();
        Timber.d("%d movies loaded. Total pages are %d.", videos.size(), searchResults.getTotalPages());
        if (videos.size() > 0) {
            // Update media list with the results
            mainTabFragment.swapAdapter(searchResults.getResults());
        }
        mainTabFragment.showMediaLoading(false);
    }

    /**
     * Notifies about an error while fetching data.
     */
    private void onLoadError(@NonNull final MainTabFragment mainTabFragment, @NonNull final Throwable e) {
        mView.onError(e);
        mainTabFragment.showMediaLoading(false);
    }
}
