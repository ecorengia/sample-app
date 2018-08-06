package com.ecorengia.org.cinemaapp.screens.main.tabs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.data.model.MovieListObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

public final class MediaListAdapter extends RecyclerView.Adapter<MediaListHolder> {
    private final PublishSubject<Integer> mItemClicks = PublishSubject.create();

    private final List<MovieListObject> mMovies = new ArrayList<>();

    @NonNull
    @Override
    public final MediaListHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_movie_item, parent, false);
        return new MediaListHolder(view, mItemClicks);
    }

    @Override
    public final void onBindViewHolder(@NonNull final MediaListHolder holder, final int position) {
        Timber.d("Movie item created at position %d.", position);
        final MovieListObject movie = mMovies.get(position);
        holder.bind(movie);
    }

    @Override
    public final int getItemCount() {
        return mMovies.size();
    }

    /**
     * Update current movie list on screen by adding all items from {@code movies}.
     *
     * @param movies New list of movies.
     */
    public final void updateMediaList(@NonNull final List<MovieListObject> movies) {
        // Update movie list with the one provided
        mMovies.addAll(movies);
        // Notify that movie list has changed
        notifyDataSetChanged();
    }

    /**
     * Returns an observable of movies selected by the user.
     *
     * @return Chosen movie flows.
     */
    public final Observable<MovieListObject> observeClicks() {
        // Retrieve chosen movie given its position
        return mItemClicks.map(mMovies::get);
    }
}
