package com.ecorengia.org.cinemaapp.screens.player.mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.mvp.MvpView;
import com.ecorengia.org.cinemaapp.screens.player.PlayerScreen;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import timber.log.Timber;

/**
 * Preview player view.
 *
 * @author ecorengia
 */
public final class PlayerView implements MvpView {
    @NonNull
    private final PlayerScreen mPlayerScreen;

    @NonNull
    private final View mView;

    public PlayerView(@NonNull final PlayerScreen activity) {
        mPlayerScreen = activity;
        // Set-up main view
        final FrameLayout parent = new FrameLayout(activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mView = LayoutInflater.from(activity).inflate(R.layout.activity_player, parent,
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
        final Context context = mView.getContext();
        Toast.makeText(context, context.getString(R.string.err_general_loading), Toast.LENGTH_LONG).show();
        // Terminate player activity, there was a problem with the loading
        mPlayerScreen.finish();
    }

    public final void onPlayerError(@NonNull final YouTubeInitializationResult errorReason) {
        final String errorMessage = String.format(mPlayerScreen.getString(R.string.err_player), errorReason.toString());
        onPlayerError(errorMessage);
    }

    public final void onPlayerError(@Nullable final String errorMessage) {
        Timber.e(errorMessage);
        Toast.makeText(mPlayerScreen, errorMessage != null ? errorMessage : mPlayerScreen.getString(R.string.err_player), Toast.LENGTH_LONG).show();
        mPlayerScreen.finish();
    }

    public final void initializePreviewPlayer(@NonNull final String youtubeKey) {
        final YouTubePlayerSupportFragment youtubeFragment = YouTubePlayerSupportFragment.newInstance();
        mPlayerScreen.replaceFragment(youtubeFragment, R.id.preview_player_container, false);
        youtubeFragment.initialize(youtubeKey, mPlayerScreen.getPresenter());
    }
}
