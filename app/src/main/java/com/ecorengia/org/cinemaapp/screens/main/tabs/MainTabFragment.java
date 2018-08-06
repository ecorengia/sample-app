package com.ecorengia.org.cinemaapp.screens.main.tabs;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.data.model.MovieListObject;
import com.ecorengia.org.cinemaapp.screens.CinemaBaseFragment;
import com.ecorengia.org.cinemaapp.screens.main.MediaSection;
import com.ecorengia.org.cinemaapp.screens.main.mvp.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import timber.log.Timber;

public final class MainTabFragment extends CinemaBaseFragment<MainPresenter> {
    private static final String ARG_SECTION_ID = "section_id";

    private MediaSection mSection;

    private MediaListAdapter mAdapter;

    private LinearLayoutManager mLayoutManager;

    @BindView(R.id.media_list_progress)
    ProgressBar mMediaProgress;

    @BindView(R.id.media_list)
    RecyclerView mMediaList;

    public MainTabFragment() {
        // Required empty public constructor
    }

    @NonNull
    public static MainTabFragment newInstance(@NonNull final MediaSection section) {
        final MainTabFragment fragment = new MainTabFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_SECTION_ID, section.getValue());
        fragment.setArguments(args);
        return fragment;
    }

    @LayoutRes
    @Override
    protected final int getLayout() {
        return R.layout.fragment_main_tab;
    }

    @Override
    public final void onCreate(@NonNull final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle args = getArguments();
        if (args != null) {
            mSection = MediaSection.valueOf(args.getInt(ARG_SECTION_ID, -1));
        }
    }

    @Override
    public final View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view == null) {
            return null;
        }
        // Set-up view dependencies
        ButterKnife.bind(this, view);

        // Set-up media list
        mAdapter = new MediaListAdapter();
        mMediaList.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mMediaList.setLayoutManager(mLayoutManager);

        if (mPresenter != null) {
            // Load media content
            mPresenter.loadContent(this, mSection);

            // Setup listeners
            mPresenter.respondToClick(this);
            mPresenter.respondToPagination(this, mSection);
        } else {
            Timber.e("Presenter has not been set.");
        }

        return view;
    }

    /**
     * Updates media progress visibility according to {@code show} value.
     */
    public final void showMediaLoading(final boolean show) {
        mMediaProgress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    /**
     * Emits scroll events including proximity information about the end of the list.
     */
    public final Flowable<Boolean> userScrolls() {
        return Flowable.create(emitter -> {
            final RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
                @Override
                public final void onScrolled(@NonNull final RecyclerView recyclerView, final int dx, final int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    // Update position parameters
                    final int visibleItemCount = mLayoutManager.getChildCount();
                    final int totalItemCount = mLayoutManager.getItemCount();
                    final int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
                    // Check if we are near the end of the list or not
                    final boolean isNearEnd = (visibleItemCount + firstVisibleItemPosition)
                            >= totalItemCount && firstVisibleItemPosition >= 0;
                    // Emit event including proximity information
                    emitter.onNext(isNearEnd);
                }
            };
            mMediaList.addOnScrollListener(listener);
            emitter.setCancellable(() -> mMediaList.removeOnScrollListener(listener));
        }, BackpressureStrategy.LATEST);
    }

    /**
     * Emits adapter list's clicks.
     */
    public final Observable<MovieListObject> itemClicks() {
        if (mAdapter == null) {
            return Observable.empty();
        }
        return mAdapter.observeClicks();
    }

    /**
     * Swaps current media list with a new one given by {@code movies}.
     */
    public final void swapAdapter(@NonNull final List<MovieListObject> movies) {
        if (mAdapter == null) {
            Timber.e("Media list adapter has not being set.");
            return;
        }
        mAdapter.updateMediaList(movies);
        showMediaLoading(false);
    }
}
