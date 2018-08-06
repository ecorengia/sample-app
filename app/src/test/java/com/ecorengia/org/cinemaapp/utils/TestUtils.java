package com.ecorengia.org.cinemaapp.utils;

import com.ecorengia.org.cinemaapp.data.model.MovieDetails;
import com.ecorengia.org.cinemaapp.data.model.MovieListObject;
import com.ecorengia.org.cinemaapp.data.model.SearchResult;
import com.ecorengia.org.cinemaapp.data.model.VideoListObject;
import com.ecorengia.org.cinemaapp.data.model.VideoResult;

import org.joda.time.DateTime;

import java.util.Collections;

public class TestUtils {

    private TestUtils() {
        // Utility class don't instantiate
    }

    public static MovieListObject provideTestMovie() {
        final MovieListObject toReturn = new MovieListObject();
        toReturn.setId(19404);
        toReturn.setTitle("Dilwale Dulhania Le Jayenge");
        toReturn.setOverview("This is a test movie.");
        toReturn.setReleaseDate(DateTime.parse("1995-10-20").toDate());
        toReturn.setPopularity(41.68F);
        toReturn.setVoteAverage(9F);
        return toReturn;
    }

    public static MovieDetails provideTestDetails() {
        final MovieDetails toReturn = new MovieDetails();
        toReturn.setId(19404);
        toReturn.setTitle("Dilwale Dulhania Le Jayenge");
        toReturn.setOverview("This is a test movie.");
        toReturn.setReleaseDate(DateTime.parse("1995-10-20").toDate());
        toReturn.setPopularity(41.68F);
        toReturn.setVoteAverage(9F);
        return toReturn;
    }

    public static SearchResult provideTestSearch() {
        final MovieListObject testMovie = provideTestMovie();
        final SearchResult toReturn = new SearchResult();
        toReturn.setResults(Collections.singletonList(testMovie));
        toReturn.setPage(1);
        toReturn.setTotalResults(1);
        toReturn.setTotalPages(1);
        return toReturn;
    }

    public static VideoResult provideVideoResult() {
        final VideoResult toReturn = new VideoResult();
        toReturn.setId("19404");
        toReturn.setSite("Youtube");
        toReturn.setKey("fhWaJi1Hsfo");
        return toReturn;
    }

    public static VideoListObject provideVideoList() {
        final VideoResult testVideo = provideVideoResult();
        final VideoListObject toReturn = new VideoListObject();
        toReturn.setResults(Collections.singletonList(testVideo));
        toReturn.setId(19404);
        return toReturn;
    }
}
