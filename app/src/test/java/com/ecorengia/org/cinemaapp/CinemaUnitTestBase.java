package com.ecorengia.org.cinemaapp;

import android.content.Context;
import android.support.annotation.NonNull;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.robolectric.RuntimeEnvironment;

import java.util.Locale;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Base class for all unit tests.
 *
 * @author ecorengia
 */
public abstract class CinemaUnitTestBase {
    protected Context testContext;

    @BeforeClass
    public static void setUpClass() {
        // Setup Timber to use the console on tests
        Timber.plant(new ConsoleTree());
        // Override Android scheduler for testing
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        // Override IO scheduler as well
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @AfterClass
    public static void tearDownClass() {
        // Reset Rx schedulers
        RxAndroidPlugins.reset();
        RxJavaPlugins.reset();
    }

    private static class ConsoleTree extends Timber.DebugTree {
        @Override
        protected void log(final int priority, final String tag, @NonNull final String message, final Throwable t) {
            System.out.println(String.format(Locale.US, "%s %d: %s", tag, priority, message));
            if (t != null) {
                t.printStackTrace();
            }
        }
    }

    @Before
    public void setUp() {
        testContext = RuntimeEnvironment.application.getBaseContext();
    }
}
