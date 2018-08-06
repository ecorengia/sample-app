package com.ecorengia.org.cinemaapp.networking.api;

import com.ecorengia.org.cinemaapp.data.model.ImageListObject;
import com.ecorengia.org.cinemaapp.data.model.MovieDetails;
import com.ecorengia.org.cinemaapp.data.model.SearchResult;
import com.ecorengia.org.cinemaapp.data.model.VideoListObject;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Cinema API endpoints.
 *
 * @author ecorengia
 */
public interface CinemaApi {

    /**
     * Get Details.
     * Get the primary information about a movie.
     *
     * @param movieId  (required)
     * @param language Pass a ISO 639-1 value to display translated data for the fields that support it. (optional)
     * @return Call&lt;MovieDetails&gt;
     */
    @GET("movie/{movie_id}")
    Single<MovieDetails> getMovieDetails(
            @retrofit2.http.Path("movie_id") Integer movieId, @retrofit2.http.Query("language") String language
    );

    /**
     * Get Images.
     * Get the images that belong to a movie.
     *
     * @param movieId  (required)
     * @param language Pass a ISO 639-1 value to display translated data for the fields that support it. (optional)
     * @return Call&lt;ImageListObject&gt;
     */
    @GET("movie/{movie_id}/images")
    Single<ImageListObject> getMovieImages(
            @retrofit2.http.Path("movie_id") Integer movieId, @retrofit2.http.Query("language") String language
    );

    /**
     * Get Videos.
     * Get the videos that have been added to a movie.
     *
     * @param movieId  (required)
     * @param language Pass a ISO 639-1 value to display translated data for the fields that support it. (optional)
     * @return Call&lt;VideoListObject&gt;
     */
    @GET("movie/{movie_id}/videos")
    Single<VideoListObject> getMovieVideos(
            @retrofit2.http.Path("movie_id") Integer movieId, @retrofit2.http.Query("language") String language
    );

    /**
     * Get Now Playing.
     * Get a list of movies in theatres. This is a release type query that looks for all movies that have a release type of 2 or 3 within the specified date range.
     *
     * @param language Pass a ISO 639-1 value to display translated data for the fields that support it. (optional)
     * @param region   Specify a ISO 3166-1 code to filter release dates. Must be uppercase. (optional)
     * @param page     Specify which page to query. (optional)
     * @return Call&lt;SearchResult&gt;
     */
    @GET("movie/now_playing")
    Single<SearchResult> getNowPlaying(
            @retrofit2.http.Query("language") String language, @retrofit2.http.Query("region") String region, @retrofit2.http.Query("page") Integer page
    );

    /**
     * Get Popular.
     * Get a list of the current popular movies on TMDb. This list updates daily.
     *
     * @param language Pass a ISO 639-1 value to display translated data for the fields that support it. (optional)
     * @param region   Specify a ISO 3166-1 code to filter release dates. Must be uppercase. (optional)
     * @param page     Specify which page to query. (optional)
     * @return Call&lt;SearchResult&gt;
     */
    @GET("movie/popular")
    Single<SearchResult> getPopular(
            @retrofit2.http.Query("language") String language, @retrofit2.http.Query("region") String region, @retrofit2.http.Query("page") Integer page
    );

    /**
     * Get Top Rated.
     * Get the top rated movies on TMDb.
     *
     * @param language Pass a ISO 639-1 value to display translated data for the fields that support it. (optional)
     * @param region   Specify a ISO 3166-1 code to filter release dates. Must be uppercase. (optional)
     * @param page     Specify which page to query. (optional)
     * @return Call&lt;SearchResult&gt;
     */
    @GET("movie/top_rated")
    Single<SearchResult> getTopRated(
            @retrofit2.http.Query("language") String language, @retrofit2.http.Query("region") String region, @retrofit2.http.Query("page") Integer page
    );
}
