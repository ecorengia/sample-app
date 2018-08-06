package com.ecorengia.org.cinemaapp.screens.main.tabs;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Main tab fragment dependencies.
 *
 * @author ecorengia
 */
@Module
public abstract class MainTabModule {
    @ContributesAndroidInjector
    abstract MainTabFragment contributeMainTabFragment();
}
