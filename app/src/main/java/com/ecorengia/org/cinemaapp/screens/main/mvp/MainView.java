package com.ecorengia.org.cinemaapp.screens.main.mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ecorengia.org.cinemaapp.R;
import com.ecorengia.org.cinemaapp.mvp.MvpView;
import com.ecorengia.org.cinemaapp.screens.main.MainPagerAdapter;
import com.ecorengia.org.cinemaapp.screens.main.MainScreen;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Main view.
 *
 * @author ecorengia
 */
public class MainView implements MvpView {
    @NonNull
    private final View mView;

    @BindView(R.id.media_list_container)
    ViewPager mViewPager;

    public MainView(@NonNull final MainScreen activity) {
        // Set-up main view
        final FrameLayout parent = new FrameLayout(activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mView = LayoutInflater.from(activity).inflate(R.layout.activity_main, parent,
                true);
        activity.setContentView(mView);
        // Set-up view dependencies
        ButterKnife.bind(this, mView);
        // Set-up sections pager
        mViewPager.setAdapter(new MainPagerAdapter(activity));
        mViewPager.setCurrentItem(1);
    }

    @NonNull
    @Override
    public final View view() {
        return mView;
    }

    @Override
    public final void onError(@NonNull final Throwable e) {
        Timber.e(e);
        final Context context = mView.getContext();
        Toast.makeText(context, context.getString(R.string.err_general_loading), Toast.LENGTH_LONG).show();
    }
}
