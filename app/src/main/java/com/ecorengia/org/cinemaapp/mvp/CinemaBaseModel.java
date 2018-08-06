package com.ecorengia.org.cinemaapp.mvp;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.ecorengia.org.cinemaapp.data.model.MovieDetails;
import com.ecorengia.org.cinemaapp.data.model.SearchResult;
import com.ecorengia.org.cinemaapp.data.model.VideoListObject;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.CinemaBaseActivity;
import com.ecorengia.org.cinemaapp.utils.RxSchedulers;
import com.google.android.gms.common.util.CollectionUtils;

import java.util.Locale;

import io.reactivex.Single;
import timber.log.Timber;

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

    @NonNull
    private final String mLanguage;

    @NonNull
    private final String mRegion;

    public CinemaBaseModel(@NonNull final S screen, @NonNull final CinemaApi cinemaApi) {
        mScreen = screen;
        mCinemaApi = cinemaApi;
        mLanguage = Locale.getDefault().getLanguage();
        mRegion = Locale.getDefault().getCountry();
        Timber.d("Current language is '%s' and region is '%s'.", mLanguage, mRegion);
    }

    /**
     * @return A list of top rated movies for page {@code page}.
     */
    public Single<SearchResult> getTopRated(final int page) {
        return mCinemaApi.getTopRated(mLanguage, mRegion, page)
                .compose(RxSchedulers.applySingleAsync());
    }

    /**
     * @return A list of popular movies for page {@code page}.
     */
    public Single<SearchResult> getPopular(final int page) {
        return mCinemaApi.getPopular(mLanguage, mRegion, page)
                .compose(RxSchedulers.applySingleAsync());
    }

    /**
     * @return A list of now playing movies for page {@code page}.
     */
    public Single<SearchResult> getNowPlaying(final int page) {
        return mCinemaApi.getNowPlaying(mLanguage, mRegion, page)
                .compose(RxSchedulers.applySingleAsync());
    }

    /**
     * @return Movie details for movie {@code movieId}.
     */
    public Single<MovieDetails> getMovieDetails(final int movieId) {
        return mCinemaApi.getMovieDetails(movieId, mLanguage)
                .flatMap(movieDetails -> {
                    // Check if we at least have overview avilable on current language, if not it use English instead
                    if (movieDetails != null && !TextUtils.isEmpty(movieDetails.getOverview())) {
                        return Single.just(movieDetails);
                    }
                    return mCinemaApi.getMovieDetails(movieId, "en");
                })
                .compose(RxSchedulers.applySingleAsync());
    }

    /**
     * @return A list of videos for movie {@code movieId}.
     */
    public Single<VideoListObject> getVideos(final int movieId) {
        return mCinemaApi.getMovieVideos(movieId, mLanguage)
                .flatMap(videoListObject -> {
                    // Check if we have videos available on current language, if not it use English instead
                    if (videoListObject != null && !CollectionUtils.isEmpty(videoListObject.getResults())) {
                        return Single.just(videoListObject);
                    }
                    return mCinemaApi.getMovieVideos(movieId, "en");
                })
                .compose(RxSchedulers.applySingleAsync());
    }
}
