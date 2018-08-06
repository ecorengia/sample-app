package com.ecorengia.org.cinemaapp.utils;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.Nullable;

import java.util.Date;

public final class DateConverter {
    @TypeConverter
    public static Date toDate(@Nullable final Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(@Nullable final Date date) {
        return date == null ? null : date.getTime();
    }
}
