package com.ecorengia.org.cinemaapp.screens.main.mvp;

import com.ecorengia.org.cinemaapp.CinemaUnitTestBase;
import com.ecorengia.org.cinemaapp.data.model.MovieListObject;
import com.ecorengia.org.cinemaapp.data.model.SearchResult;
import com.ecorengia.org.cinemaapp.screens.main.MediaSection;
import com.ecorengia.org.cinemaapp.screens.main.tabs.MainTabFragment;
import com.ecorengia.org.cinemaapp.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests {@link MainPresenter}.
 *
 * @author ecorengia
 */
public class MainPresenterTest extends CinemaUnitTestBase {
    @Mock
    MainModel model;

    @Mock
    MainView view;

    private MainPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(model, view);
    }

    @Test
    public void testTopRatedLoad() {
        final MainTabFragment testFragment = mock(MainTabFragment.class);
        final SearchResult searchResult = TestUtils.provideTestSearch();

        when(model.getTopRated(1)).thenReturn(Single.just(searchResult));
        presenter.loadContent(testFragment, MediaSection.TOP_RATED);
        verify(testFragment).swapAdapter(searchResult.getResults());
    }

    @Test
    public void testPopularLoad() {
        final MainTabFragment testFragment = mock(MainTabFragment.class);
        final SearchResult searchResult = TestUtils.provideTestSearch();

        when(model.getPopular(1)).thenReturn(Single.just(searchResult));
        presenter.loadContent(testFragment, MediaSection.POPULAR);
        verify(testFragment).swapAdapter(searchResult.getResults());
    }

    @Test
    public void testNowPlayingLoad() {
        final MainTabFragment testFragment = mock(MainTabFragment.class);
        final SearchResult searchResult = TestUtils.provideTestSearch();

        when(model.getNowPlaying(1)).thenReturn(Single.just(searchResult));
        presenter.loadContent(testFragment, MediaSection.NOW_PLAYING);
        verify(testFragment).swapAdapter(searchResult.getResults());
    }

    @Test
    public void testMovieDetailsClick() {
        final MainTabFragment testFragment = mock(MainTabFragment.class);
        final MovieListObject testMovie = TestUtils.provideTestMovie();

        when(testFragment.itemClicks()).thenReturn(Observable.just(testMovie));
        presenter.respondToClick(testFragment);
        verify(model).swapToMovieDetails(testMovie);
    }

    @Test
    public void testSectionPagination() {
        final MainTabFragment testFragment = mock(MainTabFragment.class);

        // Load the first page
        final SearchResult firstPage = TestUtils.provideTestSearch();
        firstPage.setTotalPages(2);
        firstPage.setPage(1);

        when(model.getTopRated(1)).thenReturn(Single.just(firstPage));
        presenter.loadContent(testFragment, MediaSection.TOP_RATED);
        verify(testFragment).swapAdapter(firstPage.getResults());

        // Load the second page
        final SearchResult secondPage = TestUtils.provideTestSearch();
        secondPage.getResults().get(0).setTitle("A second test title");
        secondPage.setTotalPages(2);
        secondPage.setPage(2);

        when(testFragment.userScrolls()).thenReturn(Flowable.just(Boolean.TRUE));
        when(model.getTopRated(2)).thenReturn(Single.just(secondPage));
        presenter.respondToPagination(testFragment, MediaSection.TOP_RATED);
        verify(testFragment).swapAdapter(secondPage.getResults());
    }
}
