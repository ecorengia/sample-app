package com.ecorengia.org.cinemaapp.mvp;

/**
 * Acts as the glue between the model and the view.
 *
 * @author ecorengia
 */
public interface MvpPresenter {

    void onCreate();

    void onDestroy();

    void onPause();

    void onResume();
}
