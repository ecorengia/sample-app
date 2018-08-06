package com.ecorengia.org.cinemaapp.screens.player.mvp;

import com.ecorengia.org.cinemaapp.BuildConfig;
import com.ecorengia.org.cinemaapp.CinemaUnitTestBase;
import com.ecorengia.org.cinemaapp.data.model.MovieDetails;
import com.ecorengia.org.cinemaapp.data.model.VideoListObject;
import com.ecorengia.org.cinemaapp.utils.TestUtils;
import com.google.android.youtube.player.YouTubePlayer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Single;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests {@link PlayerPresenter}.
 *
 * @author ecorengia
 */
public class PlayerPresenterTest extends CinemaUnitTestBase {
    @Mock
    PlayerModel model;

    @Mock
    PlayerView view;

    private PlayerPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new PlayerPresenter(model, view);
    }

    @Test
    public void testPlayerInitialization() {
        final MovieDetails testDetails = TestUtils.provideTestDetails();
        final VideoListObject testMovies = TestUtils.provideVideoList();

        when(model.getVideos(testDetails.getId())).thenReturn(Single.just(testMovies));
        presenter.setMovieId(testDetails.getId());

        presenter.onCreate();
        verify(view).initializePreviewPlayer(BuildConfig.YOUTUBE_API_KEY);
    }

    @Test
    public void testPlayerVideoLoad() {
        final YouTubePlayer.Provider provider = mock(YouTubePlayer.Provider.class);
        final YouTubePlayer player = mock(YouTubePlayer.class);

        final MovieDetails testDetails = TestUtils.provideTestDetails();
        final VideoListObject testMovies = TestUtils.provideVideoList();

        when(model.getVideos(testDetails.getId())).thenReturn(Single.just(testMovies));
        presenter.setMovieId(testDetails.getId());

        presenter.onCreate();
        verify(view).initializePreviewPlayer(BuildConfig.YOUTUBE_API_KEY);

        presenter.onInitializationSuccess(provider, player, false);
        verify(model).getVideos(testDetails.getId());
    }

}
