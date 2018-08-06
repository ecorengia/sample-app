package com.ecorengia.org.cinemaapp.screens.main.tabs;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ecorengia.org.cinemaapp.BuildConfig;
import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.data.model.MovieListObject;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public final class MediaListHolder extends RecyclerView.ViewHolder {

    private static final DateTimeFormatter MOVIE_DATE_FORMATTER = DateTimeFormat.forPattern("yyyy");

    @NonNull
    private final View mView;

    @BindView(R.id.item_progress)
    ProgressBar movieProgress;

    @BindView(R.id.item_thumbnail)
    ImageView movieImage;

    @BindView(R.id.item_movie_title)
    TextView movieName;

    @BindView(R.id.item_movie_date)
    TextView movieYear;

    @BindView(R.id.item_movie_rank)
    TextView movieRank;

    @BindView(R.id.item_movie_summary)
    TextView movieSummary;

    @BindView(R.id.item_movie_more)
    TextView movieMore;

    /* package */ MediaListHolder(@NonNull final View itemView, @NonNull final PublishSubject<Integer> clickSubject) {
        // Initialize holder
        super(itemView);
        this.mView = itemView;
        // Setup view dependencies
        ButterKnife.bind(this, mView);
        // Setup listeners
        movieMore.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition()));
    }

    /**
     * Update view using the data provided from {@code movie}.
     *
     * @param movie The movie to bind to.
     */
    /* package */ final void bind(@NonNull final MovieListObject movie) {
        // Refresh progress (holders are being reused)
        movieProgress.setVisibility(View.VISIBLE);
        // Set movie thumbnail and placeholder
        Glide.with(mView.getContext())
                .load(BuildConfig.TMDB_THUMBS_URL + movie.getPosterPath())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public final boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // Hide progress bar on error
                        movieProgress.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public final boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        // Hide progress bar once we load the image
                        movieProgress.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(movieImage);
        // Set video title and summary
        movieName.setText(movie.getTitle());
        movieSummary.setText(movie.getOverview());
        // Parse and set movie date
        final LocalDate releaseDate = LocalDate.fromDateFields(movie.getReleaseDate());
        movieYear.setText(releaseDate.toString(MOVIE_DATE_FORMATTER));
        // Finally, set movie rank
        movieRank.setText(String.valueOf(movie.getVoteAverage()));
    }
}
