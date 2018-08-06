package com.ecorengia.org.cinemaapp.app;


import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * App module, provides common app dependencies such app context,
 * preferences, etc.
 *
 * @author ecorengia
 */
@Module
/* package */ abstract class CinemaAppModule {

    /**
     * Expose Application as an injectable context.
     */
    @Binds
    abstract Context bindContext(final Application application);
}
