package com.ecorengia.org.cinemaapp.screens.main;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.screens.main.tabs.MainTabFragment;

import timber.log.Timber;

public final class MainPagerAdapter extends FragmentPagerAdapter {
    @NonNull
    private final MainScreen mMainScreen;

    public MainPagerAdapter(@NonNull final MainScreen mainScreen) {
        super(mainScreen.getSupportFragmentManager());
        mMainScreen = mainScreen;
    }

    @Override
    public final Fragment getItem(final int position) {
        switch (MediaSection.valueOf(position)) {
            case TOP_RATED:
                return MainTabFragment.newInstance(MediaSection.TOP_RATED);
            case POPULAR:
                return MainTabFragment.newInstance(MediaSection.POPULAR);
            case NOW_PLAYING:
                return MainTabFragment.newInstance(MediaSection.NOW_PLAYING);
            default:
                Timber.w("Undefined position %d selected.", position);
                return null;
        }
    }

    @Override
    public final int getCount() {
        // Show 3 total pages(popular, top rated and now playing)
        return 3;
    }

    @Override
    public final CharSequence getPageTitle(final int position) {
        switch (MediaSection.valueOf(position)) {
            case TOP_RATED:
                return mMainScreen.getString(R.string.section_top_rated);
            case POPULAR:
                return mMainScreen.getString(R.string.section_popular);
            case NOW_PLAYING:
                return mMainScreen.getString(R.string.section_now_playing);
            default:
                return null;
        }
    }
}
