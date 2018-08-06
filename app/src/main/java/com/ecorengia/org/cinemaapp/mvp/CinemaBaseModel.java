package com.ecorengia.org.cinemaapp.mvp;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.data.model.MovieDetails;
import com.ecorengia.org.cinemaapp.data.model.SearchResult;
import com.ecorengia.org.cinemaapp.data.model.VideoListObject;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.CinemaBaseActivity;
import com.ecorengia.org.cinemaapp.utils.RxSchedulers;

import io.reactivex.Single;

/**
 * Base cinema model that provides access to common movie endpoints.
 *
 * @param <S> The {@link CinemaBaseActivity} associated to this model.
 * @author ecorengia
 */
public abstract class CinemaBaseModel<S extends CinemaBaseActivity> implements MvpModel {
    @NonNull
    protected final S mScreen;

    @NonNull
    private final CinemaApi mCinemaApi;

    public CinemaBaseModel(@NonNull final S screen, @NonNull final CinemaApi cinemaApi) {
        mScreen = screen;
        mCinemaApi = cinemaApi;
    }

    /**
     * @return A list of top rated movies for page {@code page}.
     */
    public Single<SearchResult> getTopRated(final int page) {
        return mCinemaApi.getTopRated("en", "US", page)    // TODO read lang and region from preferences.
                .compose(RxSchedulers.applySingleAsync());
    }

    /**
     * @return A list of popular movies for page {@code page}.
     */
    public Single<SearchResult> getPopular(final int page) {
        return mCinemaApi.getPopular("en", "US", page)
                .compose(RxSchedulers.applySingleAsync());
    }

    /**
     * @return A list of now playing movies for page {@code page}.
     */
    public Single<SearchResult> getNowPlaying(final int page) {
        return mCinemaApi.getNowPlaying("en", "US", page)
                .compose(RxSchedulers.applySingleAsync());
    }

    /**
     * @return Movie details for movie {@code movieId}.
     */
    public Single<MovieDetails> getMovieDetails(final int movieId) {
        return mCinemaApi.getMovieDetails(movieId, "en")
                .compose(RxSchedulers.applySingleAsync());
    }

    /**
     * @return A list of videos for movie {@code movieId}.
     */
    public Single<VideoListObject> getVideos(final int movieId) {
        return mCinemaApi.getMovieVideos(movieId, "en")
                .compose(RxSchedulers.applySingleAsync());
    }
}
