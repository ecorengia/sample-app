package com.ecorengia.org.cinemaapp.utils;

import android.support.annotation.Nullable;

/**
 * Utility arrays methods.
 *
 * @author ecorengia
 */
public final class ArrayUtils {

    private ArrayUtils() {
        // Utility class don't instantiate
    }

    public static boolean isEmpty(@Nullable final Object[] o) {
        return o == null || o.length < 1;
    }
}