package com.ecorengia.org.cinemaapp.screens.player.mvp;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.ecorengia.org.cinemaapp.BuildConfig;
import com.ecorengia.org.cinemaapp.data.model.VideoListObject;
import com.ecorengia.org.cinemaapp.data.model.VideoResult;
import com.ecorengia.org.cinemaapp.mvp.MvpPresenter;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import java.util.Collections;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class PlayerPresenter implements MvpPresenter, YouTubePlayer.OnInitializedListener {
    @NonNull
    private final PlayerModel mModel;

    @NonNull
    private final PlayerView mView;

    @NonNull
    private final CompositeDisposable mDisposable;

    @Nullable
    private YouTubePlayer mYouTubePlayer;

    @IntRange(from = 0)
    private int mMovieId;

    public PlayerPresenter(@NonNull final PlayerModel model, @NonNull final PlayerView view) {
        mModel = model;
        mView = view;
        mDisposable = new CompositeDisposable();

    }

    @Override
    public void onCreate() {
        // Initialize player right away
        mView.initializePreviewPlayer(BuildConfig.YOUTUBE_API_KEY);
    }

    @Override
    public void onDestroy() {
        mDisposable.clear();
        if (mYouTubePlayer != null) {
            mYouTubePlayer.release();
            mYouTubePlayer = null;
        }
    }

    @Override
    public void onPause() {
        // No-op
    }

    @Override
    public void onResume() {
        // No-op
    }

    @Override
    public void onInitializationSuccess(final YouTubePlayer.Provider provider, final YouTubePlayer player, final boolean wasRestored) {
        Timber.d("Preview player has been initialized.");
        mYouTubePlayer = player;
        mYouTubePlayer.setShowFullscreenButton(false);
        // Retrieve video preview
        moviePreview();
    }

    @Override
    public void onInitializationFailure(final YouTubePlayer.Provider provider, final YouTubeInitializationResult errorReason) {
        mView.onPlayerError(errorReason);
    }

    /**
     * Queries movie videos for the current {@code mMovieId}.
     */
    private void moviePreview() {
        mDisposable.add(mModel.getVideos(mMovieId).subscribe(this::onVideosLoaded, mView::onError));
    }

    /**
     * Play retrieved video.
     */
    private void onVideosLoaded(@NonNull final VideoListObject videoList) {
        Timber.d("Movie preview videos have been loaded.");
        final List<VideoResult> videos = videoList.getResults() != null ? videoList.getResults() : Collections.emptyList();
        Timber.d("%d preview videos loaded.", videos.size());
        if (mYouTubePlayer != null && videos.size() > 0) {
            final VideoResult previewVideo = videos.get(0);
            mYouTubePlayer.loadVideo(previewVideo.getKey());
        } else {
            mView.onPlayerError((String) null);
        }
    }

    @IntRange(from = 0)
    public int getMovieId() {
        return mMovieId;
    }

    public void setMovieId(@IntRange(from = 0) int mMovieId) {
        this.mMovieId = mMovieId;
    }
}
