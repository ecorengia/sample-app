package com.ecorengia.org.cinemaapp.data.model;

import android.arch.persistence.room.TypeConverter;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * MovieListObject
 */
public final class MovieListObject implements Parcelable {
    @SerializedName("poster_path")
    private String posterPath = null;

    @SerializedName("adult")
    private Boolean adult = null;

    @SerializedName("overview")
    private String overview = null;

    @SerializedName("release_date")
    private Date releaseDate = null;

    @SerializedName("genre_ids")
    private List<Integer> genreIds = null;

    @SerializedName("id")
    private Integer id = null;

    @SerializedName("original_title")
    private String originalTitle = null;

    @SerializedName("original_language")
    private String originalLanguage = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("backdrop_path")
    private String backdropPath = null;

    @SerializedName("popularity")
    private Float popularity = null;

    @SerializedName("vote_count")
    private Integer voteCount = null;

    @SerializedName("video")
    private Boolean video = null;

    @SerializedName("vote_average")
    private Float voteAverage = null;

    public MovieListObject posterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    /**
     * Get posterPath
     *
     * @return posterPath
     **/
    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public MovieListObject adult(Boolean adult) {
        this.adult = adult;
        return this;
    }

    /**
     * Get adult
     *
     * @return adult
     **/
    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public MovieListObject overview(String overview) {
        this.overview = overview;
        return this;
    }

    /**
     * Get overview
     *
     * @return overview
     **/
    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public MovieListObject releaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    /**
     * Get releaseDate
     *
     * @return releaseDate
     **/
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MovieListObject genreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
        return this;
    }

    public MovieListObject addGenreIdsItem(Integer genreIdsItem) {
        if (this.genreIds == null) {
            this.genreIds = new ArrayList<>();
        }
        this.genreIds.add(genreIdsItem);
        return this;
    }

    /**
     * Get genreIds
     *
     * @return genreIds
     **/
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public MovieListObject id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieListObject originalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    /**
     * Get originalTitle
     *
     * @return originalTitle
     **/
    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public MovieListObject originalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    /**
     * Get originalLanguage
     *
     * @return originalLanguage
     **/
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public MovieListObject title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieListObject backdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    /**
     * Get backdropPath
     *
     * @return backdropPath
     **/
    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public MovieListObject popularity(Float popularity) {
        this.popularity = popularity;
        return this;
    }

    /**
     * Get popularity
     *
     * @return popularity
     **/
    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public MovieListObject voteCount(Integer voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    /**
     * Get voteCount
     *
     * @return voteCount
     **/
    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public MovieListObject video(Boolean video) {
        this.video = video;
        return this;
    }

    /**
     * Get video
     *
     * @return video
     **/
    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public MovieListObject voteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    /**
     * Get voteAverage
     *
     * @return voteAverage
     **/
    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovieListObject movieListObject = (MovieListObject) o;
        return Objects.equals(this.posterPath, movieListObject.posterPath) &&
                Objects.equals(this.adult, movieListObject.adult) &&
                Objects.equals(this.overview, movieListObject.overview) &&
                Objects.equals(this.releaseDate, movieListObject.releaseDate) &&
                Objects.equals(this.genreIds, movieListObject.genreIds) &&
                Objects.equals(this.id, movieListObject.id) &&
                Objects.equals(this.originalTitle, movieListObject.originalTitle) &&
                Objects.equals(this.originalLanguage, movieListObject.originalLanguage) &&
                Objects.equals(this.title, movieListObject.title) &&
                Objects.equals(this.backdropPath, movieListObject.backdropPath) &&
                Objects.equals(this.popularity, movieListObject.popularity) &&
                Objects.equals(this.voteCount, movieListObject.voteCount) &&
                Objects.equals(this.video, movieListObject.video) &&
                Objects.equals(this.voteAverage, movieListObject.voteAverage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posterPath, adult, overview, releaseDate, genreIds, id, originalTitle, originalLanguage, title, backdropPath, popularity, voteCount, video, voteAverage);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MovieListObject {\n");

        sb.append("    posterPath: ").append(toIndentedString(posterPath)).append("\n");
        sb.append("    adult: ").append(toIndentedString(adult)).append("\n");
        sb.append("    overview: ").append(toIndentedString(overview)).append("\n");
        sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
        sb.append("    genreIds: ").append(toIndentedString(genreIds)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    originalTitle: ").append(toIndentedString(originalTitle)).append("\n");
        sb.append("    originalLanguage: ").append(toIndentedString(originalLanguage)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    backdropPath: ").append(toIndentedString(backdropPath)).append("\n");
        sb.append("    popularity: ").append(toIndentedString(popularity)).append("\n");
        sb.append("    voteCount: ").append(toIndentedString(voteCount)).append("\n");
        sb.append("    video: ").append(toIndentedString(video)).append("\n");
        sb.append("    voteAverage: ").append(toIndentedString(voteAverage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public void writeToParcel(Parcel out, int flags) {

        out.writeValue(posterPath);

        out.writeValue(adult);

        out.writeValue(overview);

        out.writeValue(releaseDate);

        out.writeValue(genreIds);

        out.writeValue(id);

        out.writeValue(originalTitle);

        out.writeValue(originalLanguage);

        out.writeValue(title);

        out.writeValue(backdropPath);

        out.writeValue(popularity);

        out.writeValue(voteCount);

        out.writeValue(video);

        out.writeValue(voteAverage);
    }

    public MovieListObject() {
        super();
    }

    MovieListObject(Parcel in) {

        posterPath = (String) in.readValue(getClass().getClassLoader());
        adult = (Boolean) in.readValue(getClass().getClassLoader());
        overview = (String) in.readValue(getClass().getClassLoader());
        releaseDate = (Date) in.readValue(Date.class.getClassLoader());
        genreIds = (List<Integer>) in.readValue(getClass().getClassLoader());
        id = (Integer) in.readValue(getClass().getClassLoader());
        originalTitle = (String) in.readValue(getClass().getClassLoader());
        originalLanguage = (String) in.readValue(getClass().getClassLoader());
        title = (String) in.readValue(getClass().getClassLoader());
        backdropPath = (String) in.readValue(getClass().getClassLoader());
        popularity = (Float) in.readValue(Float.class.getClassLoader());
        voteCount = (Integer) in.readValue(getClass().getClassLoader());
        video = (Boolean) in.readValue(getClass().getClassLoader());
        voteAverage = (Float) in.readValue(Float.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<MovieListObject> CREATOR = new Parcelable.Creator<MovieListObject>() {
        public MovieListObject createFromParcel(Parcel in) {
            return new MovieListObject(in);
        }

        public MovieListObject[] newArray(int size) {
            return new MovieListObject[size];
        }
    };

    /* package */ final static class MovieListObjectTypeConverter {
        final static Gson gson = new Gson();

        @TypeConverter
        public static List<MovieListObject> stringToMovieListObjectList(@Nullable final String data) {
            if (data == null) {
                return Collections.emptyList();
            }

            final Type listType = new TypeToken<List<MovieListObject>>() {
            }.getType();

            return gson.fromJson(data, listType);
        }

        @TypeConverter
        public static String movieListObjectListToString(List<MovieListObject> someObjects) {
            return gson.toJson(someObjects);
        }
    }
}
