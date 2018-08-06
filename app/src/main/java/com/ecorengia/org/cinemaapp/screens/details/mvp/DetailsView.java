package com.ecorengia.org.cinemaapp.screens.details.mvp;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ecorengia.org.cinemaapp.BuildConfig;
import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.data.model.MovieDetails;
import com.ecorengia.org.cinemaapp.data.model.MovieGenre;
import com.ecorengia.org.cinemaapp.mvp.MvpView;
import com.ecorengia.org.cinemaapp.screens.details.DetailsScreen;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

/**
 * Details view.
 *
 * @author ecorengia
 */
public final class DetailsView implements MvpView {
    private static final DateTimeFormatter MOVIE_DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");

    private final PublishSubject<MovieDetails> mPreviewClicks = PublishSubject.create();

    @NonNull
    private final View mView;

    @BindView(R.id.details_progress)
    ProgressBar mMediaProgress;

    @BindView(R.id.details_thumb)
    ImageView mMediaThumb;

    @BindView(R.id.movie_details_title)
    TextView mMediaTitle;

    @BindView(R.id.movie_details_tagline)
    TextView mMediaTagline;

    @BindView(R.id.movie_details_summary)
    TextView mMediaSummary;

    @BindView(R.id.movie_genres)
    TextView mMovieGenres;

    @BindView(R.id.item_movie_date)
    TextView mMovieYear;

    @BindView(R.id.item_movie_rank)
    TextView mMovieRank;

    @BindView(R.id.movie_details_top)
    ViewGroup mPreviewGroup;

    public DetailsView(@NonNull final DetailsScreen activity) {
        // Set-up main view
        final FrameLayout parent = new FrameLayout(activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mView = LayoutInflater.from(activity).inflate(R.layout.activity_details, parent,
                true);
        activity.setContentView(mView);
        // Set-up view dependencies
        ButterKnife.bind(this, mView);
    }

    @NonNull
    @Override
    public final View view() {
        return mView;
    }

    @Override
    public final void onError(@NonNull final Throwable e) {
        Timber.e(e);
        Toast.makeText(mView.getContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    /**
     * Maps movie details into video preview ids.
     */
    public Observable<Integer> previewClicks() {
        return mPreviewClicks.map(MovieDetails::getId);
    }

    /**
     * Update view using the details provided from {@code movieDetails}.
     *
     * @param movieDetails The movie details to bind to.
     */
    /* package */
    final void bind(@NonNull final MovieDetails movieDetails) {
        // Set movie logo image
        Glide.with(mView.getContext())
                .load(BuildConfig.TMDB_FULL_THUMBS_URL + movieDetails.getBackdropPath())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public final boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // Hide progress bar once we load the image
                        mMediaProgress.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public final boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        // Hide progress bar on error
                        mMediaProgress.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(mMediaThumb);
        // Update title, tagline and summary
        mMediaTitle.setText(movieDetails.getTitle());
        mMediaTagline.setText(movieDetails.getTagline());
        mMediaSummary.setText(movieDetails.getOverview());
        if (TextUtils.isEmpty(mMediaTagline.getText())) {
            mMediaTagline.setVisibility(View.GONE);
        }
        // Parse and set movie date and rank
        final LocalDate releaseDate = LocalDate.fromDateFields(movieDetails.getReleaseDate());
        mMovieYear.setText(releaseDate.toString(MOVIE_DATE_FORMATTER));
        mMovieRank.setText(String.valueOf(movieDetails.getVoteAverage()));
        // Setup preview listener
        mPreviewGroup.setOnClickListener(v -> mPreviewClicks.onNext(movieDetails));
        // Finally, set movie genres
        updateMovieGenres(movieDetails.getGenres());
    }

    /**
     * Builds a simple string from a list of genres.
     */
    private void updateMovieGenres(@Nullable final List<MovieGenre> genres) {
        if (genres == null || genres.size() == 0) {
            mMovieGenres.setVisibility(View.GONE);
            return;
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < genres.size(); i++) {
            final MovieGenre genre = genres.get(i);
            final String genreName = genre.getName();
            builder.append(!TextUtils.isEmpty(genreName) ? genreName.toUpperCase() : "");
            if (i < genres.size() - 1) {
                builder.append(",");
            }
            builder.append(" ");
        }
        mMovieGenres.setText(builder.toString().trim());
    }
}
