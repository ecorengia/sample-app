package com.ecorengia.org.cinemaapp.app;

import com.ecorengia.org.cinemaapp.screens.details.DetailsScreen;
import com.ecorengia.org.cinemaapp.screens.details.di.DetailsModule;
import com.ecorengia.org.cinemaapp.screens.main.MainScreen;
import com.ecorengia.org.cinemaapp.screens.main.di.MainModule;
import com.ecorengia.org.cinemaapp.screens.main.tabs.MainTabModule;
import com.ecorengia.org.cinemaapp.screens.splash.SplashScreen;
import com.ecorengia.org.cinemaapp.screens.splash.di.SplashModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Activity bindings.
 *
 * @author ecorengia
 */
@Module
/* package */ abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashScreen splashScreen();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {MainModule.class, MainTabModule.class})
    abstract MainScreen mainScreen();

    @ActivityScoped
    @ContributesAndroidInjector(modules = DetailsModule.class)
    abstract DetailsScreen detailsScreen();
}
