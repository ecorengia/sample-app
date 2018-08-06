package com.ecorengia.org.cinemaapp.screens.splash.mvp;

import com.ecorengia.org.cinemaapp.CinemaUnitTestBase;
import com.ecorengia.org.cinemaapp.data.model.SearchResult;
import com.ecorengia.org.cinemaapp.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests {@link SplashPresenter}.
 *
 * @author ecorengia
 */
public class SplashPresenterTest extends CinemaUnitTestBase {
    @Mock
    SplashModel model;

    @Mock
    SplashView view;

    private SplashPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new SplashPresenter(model, view);
    }

    @Test
    public void testSplashLoad() {
        final SearchResult testSearch = TestUtils.provideTestSearch();

        when(model.getPopular(1)).thenReturn(Single.just(testSearch));
        when(model.getTopRated(1)).thenReturn(Single.just(testSearch));
        when(model.getNowPlaying(1)).thenReturn(Single.just(testSearch));
        presenter.onCreate();
        verify(model).swapToMainScreen();
    }
}
