package com.ecorengia.org.cinemaapp.mvp;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Represents the view elements of the data being shown.
 *
 * @author ecorengia
 */
public interface MvpView {

    @NonNull
    View view();

    void onError(@NonNull final Throwable e);
}
