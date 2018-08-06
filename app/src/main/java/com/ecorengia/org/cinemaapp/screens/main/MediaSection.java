package com.ecorengia.org.cinemaapp.screens.main;

public enum MediaSection {
    UNDEFINED(-1),
    TOP_RATED(0),
    POPULAR(1),
    NOW_PLAYING(2);

    final int value;

    /* package */ MediaSection(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MediaSection valueOf(final int value) {
        switch (value) {
            case 0:
                return TOP_RATED;
            case 1:
                return POPULAR;
            case 2:
                return NOW_PLAYING;
            default:
                return UNDEFINED;
        }
    }
}
