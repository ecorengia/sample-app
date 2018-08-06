package com.ecorengia.org.cinemaapp.app;

import com.ecorengia.org.cinemaapp.networking.ApiModule;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * App global dependencies.
 *
 * @author ecorengia
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        ApiModule.class})
public interface CinemaAppComponent extends AndroidInjector<CinemaApp> {

    CinemaApp application();

    @Named("CinemaApi")
    CinemaApi cinemaApi();

    @Component.Builder
    interface Builder {
        @BindsInstance
        CinemaAppComponent.Builder application(final CinemaApp application);

        @BindsInstance
        CinemaAppComponent.Builder cinemaApiUrl(@Named("CinemaApiUrl") final String cinemaApiUrl);

        CinemaAppComponent build();
    }
}
