package com.ecorengia.org.cinemaapp.screens.details.mvp;

import com.ecorengia.org.cinemaapp.CinemaUnitTestBase;
import com.ecorengia.org.cinemaapp.data.model.MovieDetails;
import com.ecorengia.org.cinemaapp.data.model.MovieListObject;
import com.ecorengia.org.cinemaapp.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests {@link DetailsPresenter}.
 *
 * @author ecorengia
 */
public class DetailsPresenterTest extends CinemaUnitTestBase {
    @Mock
    DetailsModel model;

    @Mock
    DetailsView view;

    private DetailsPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new DetailsPresenter(model, view);
    }

    @Test
    public void testMovieDetailsLoad() {
        final MovieListObject testMovie = TestUtils.provideTestMovie();
        final MovieDetails testDetails = TestUtils.provideTestDetails();

        when(model.getMovieDetails(testMovie.getId())).thenReturn(Single.just(testDetails));
        presenter.showDetails(testMovie.getId());
        verify(model).getMovieDetails(testDetails.getId());
    }

    @Test
    public void testMoviePreview() {
        final MovieDetails testDetails = TestUtils.provideTestDetails();

        when(view.previewClicks()).thenReturn(Observable.just(testDetails.getId()));
        presenter.respondToPreview();
        verify(model).swapToVideoPlayer(testDetails.getId());
    }
}
