package com.ecorengia.org.cinemaapp.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Maps the primary information about a movie.
 *
 * @see <a href="https://developers.themoviedb.org/3/movies/get-movie-details">get-movie-details</a>
 */
@Entity(tableName = "movie_details")
public final class MovieDetails implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int dbId;

    @SerializedName("adult")
    private Boolean adult = null;

    @SerializedName("backdrop_path")
    private String backdropPath = null;

    @SerializedName("budget")
    private Integer budget = null;

    @TypeConverters(MovieGenre.MovieGenreTypeConverter.class)
    @SerializedName("genres")
    private List<MovieGenre> genres = null;

    @SerializedName("homepage")
    private String homepage = null;

    @SerializedName("id")
    private Integer id = null;

    @SerializedName("imdb_id")
    private String imdbId = null;

    @SerializedName("original_language")
    private String originalLanguage = null;

    @SerializedName("original_title")
    private String originalTitle = null;

    @SerializedName("overview")
    private String overview = null;

    @SerializedName("popularity")
    private Float popularity = null;

    @SerializedName("poster_path")
    private String posterPath = null;

    @TypeConverters(ProductionCompanies.ProductionCompaniesTypeConverter.class)
    @SerializedName("production_companies")
    private List<ProductionCompanies> productionCompanies = null;

    @TypeConverters(ProductionCountries.ProductionCountriesTypeConverter.class)
    @SerializedName("production_countries")
    private List<ProductionCountries> productionCountries = null;

    @SerializedName("release_date")
    private Date releaseDate = null;

    @SerializedName("revenue")
    private Integer revenue = null;

    @SerializedName("runtime")
    private Integer runtime = null;

    @TypeConverters(SpokenLanguages.SpokenLanguagesTypeConverter.class)
    @SerializedName("spoken_languages")
    private List<SpokenLanguages> spokenLanguages = null;

    @SerializedName("status")
    private String status = null;

    @SerializedName("tagline")
    private String tagline = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("video")
    private Boolean video = null;

    @SerializedName("vote_average")
    private Float voteAverage = null;

    @SerializedName("vote_count")
    private Integer voteCount = null;

    public MovieDetails adult(Boolean adult) {
        this.adult = adult;
        return this;
    }

    /**
     * Get DB id
     *
     * @return dbId
     **/
    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
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

    public MovieDetails backdropPath(String backdropPath) {
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

    public MovieDetails budget(Integer budget) {
        this.budget = budget;
        return this;
    }

    /**
     * Get budget
     *
     * @return budget
     **/
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public MovieDetails genres(List<MovieGenre> genres) {
        this.genres = genres;
        return this;
    }

    public MovieDetails addGenresItem(MovieGenre genresItem) {
        if (this.genres == null) {
            this.genres = new ArrayList<>();
        }
        this.genres.add(genresItem);
        return this;
    }

    /**
     * Get genres
     *
     * @return genres
     **/
    public List<MovieGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieGenre> genres) {
        this.genres = genres;
    }

    public MovieDetails homepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    /**
     * Get homepage
     *
     * @return homepage
     **/
    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public MovieDetails id(Integer id) {
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

    public MovieDetails imdbId(String imdbId) {
        this.imdbId = imdbId;
        return this;
    }

    /**
     * Get imdbId
     *
     * @return imdbId
     **/
    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public MovieDetails originalLanguage(String originalLanguage) {
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

    public MovieDetails originalTitle(String originalTitle) {
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

    public MovieDetails overview(String overview) {
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

    public MovieDetails popularity(Float popularity) {
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

    public MovieDetails posterPath(String posterPath) {
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

    public MovieDetails productionCompanies(List<ProductionCompanies> productionCompanies) {
        this.productionCompanies = productionCompanies;
        return this;
    }

    public MovieDetails addProductionCompaniesItem(ProductionCompanies productionCompaniesItem) {
        if (this.productionCompanies == null) {
            this.productionCompanies = new ArrayList<>();
        }
        this.productionCompanies.add(productionCompaniesItem);
        return this;
    }

    /**
     * Get productionCompanies
     *
     * @return productionCompanies
     **/
    public List<ProductionCompanies> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompanies> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public MovieDetails productionCountries(List<ProductionCountries> productionCountries) {
        this.productionCountries = productionCountries;
        return this;
    }

    public MovieDetails addProductionCountriesItem(ProductionCountries productionCountriesItem) {
        if (this.productionCountries == null) {
            this.productionCountries = new ArrayList<>();
        }
        this.productionCountries.add(productionCountriesItem);
        return this;
    }

    /**
     * Get productionCountries
     *
     * @return productionCountries
     **/
    public List<ProductionCountries> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountries> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public MovieDetails releaseDate(Date releaseDate) {
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

    public MovieDetails revenue(Integer revenue) {
        this.revenue = revenue;
        return this;
    }

    /**
     * Get revenue
     *
     * @return revenue
     **/
    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public MovieDetails runtime(Integer runtime) {
        this.runtime = runtime;
        return this;
    }

    /**
     * Get runtime
     *
     * @return runtime
     **/
    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public MovieDetails spokenLanguages(List<SpokenLanguages> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
        return this;
    }

    public MovieDetails addSpokenLanguagesItem(SpokenLanguages spokenLanguagesItem) {
        if (this.spokenLanguages == null) {
            this.spokenLanguages = new ArrayList<>();
        }
        this.spokenLanguages.add(spokenLanguagesItem);
        return this;
    }

    /**
     * Get spokenLanguages
     *
     * @return spokenLanguages
     **/
    public List<SpokenLanguages> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguages> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public MovieDetails status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MovieDetails tagline(String tagline) {
        this.tagline = tagline;
        return this;
    }

    /**
     * Get tagline
     *
     * @return tagline
     **/
    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public MovieDetails title(String title) {
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

    public MovieDetails video(Boolean video) {
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

    public MovieDetails voteAverage(Float voteAverage) {
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

    public MovieDetails voteCount(Integer voteCount) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovieDetails movieDetails = (MovieDetails) o;
        return Objects.equals(this.adult, movieDetails.adult) &&
                Objects.equals(this.backdropPath, movieDetails.backdropPath) &&
                Objects.equals(this.budget, movieDetails.budget) &&
                Objects.equals(this.genres, movieDetails.genres) &&
                Objects.equals(this.homepage, movieDetails.homepage) &&
                Objects.equals(this.id, movieDetails.id) &&
                Objects.equals(this.imdbId, movieDetails.imdbId) &&
                Objects.equals(this.originalLanguage, movieDetails.originalLanguage) &&
                Objects.equals(this.originalTitle, movieDetails.originalTitle) &&
                Objects.equals(this.overview, movieDetails.overview) &&
                Objects.equals(this.popularity, movieDetails.popularity) &&
                Objects.equals(this.posterPath, movieDetails.posterPath) &&
                Objects.equals(this.productionCompanies, movieDetails.productionCompanies) &&
                Objects.equals(this.productionCountries, movieDetails.productionCountries) &&
                Objects.equals(this.releaseDate, movieDetails.releaseDate) &&
                Objects.equals(this.revenue, movieDetails.revenue) &&
                Objects.equals(this.runtime, movieDetails.runtime) &&
                Objects.equals(this.spokenLanguages, movieDetails.spokenLanguages) &&
                Objects.equals(this.status, movieDetails.status) &&
                Objects.equals(this.tagline, movieDetails.tagline) &&
                Objects.equals(this.title, movieDetails.title) &&
                Objects.equals(this.video, movieDetails.video) &&
                Objects.equals(this.voteAverage, movieDetails.voteAverage) &&
                Objects.equals(this.voteCount, movieDetails.voteCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adult, backdropPath, budget, genres, homepage, id, imdbId, originalLanguage, originalTitle, overview, popularity, posterPath, productionCompanies, productionCountries, releaseDate, revenue, runtime, spokenLanguages, status, tagline, title, video, voteAverage, voteCount);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MovieDetails {\n");

        sb.append("    adult: ").append(toIndentedString(adult)).append("\n");
        sb.append("    backdropPath: ").append(toIndentedString(backdropPath)).append("\n");
        sb.append("    budget: ").append(toIndentedString(budget)).append("\n");
        sb.append("    genres: ").append(toIndentedString(genres)).append("\n");
        sb.append("    homepage: ").append(toIndentedString(homepage)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    imdbId: ").append(toIndentedString(imdbId)).append("\n");
        sb.append("    originalLanguage: ").append(toIndentedString(originalLanguage)).append("\n");
        sb.append("    originalTitle: ").append(toIndentedString(originalTitle)).append("\n");
        sb.append("    overview: ").append(toIndentedString(overview)).append("\n");
        sb.append("    popularity: ").append(toIndentedString(popularity)).append("\n");
        sb.append("    posterPath: ").append(toIndentedString(posterPath)).append("\n");
        sb.append("    productionCompanies: ").append(toIndentedString(productionCompanies)).append("\n");
        sb.append("    productionCountries: ").append(toIndentedString(productionCountries)).append("\n");
        sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
        sb.append("    revenue: ").append(toIndentedString(revenue)).append("\n");
        sb.append("    runtime: ").append(toIndentedString(runtime)).append("\n");
        sb.append("    spokenLanguages: ").append(toIndentedString(spokenLanguages)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    tagline: ").append(toIndentedString(tagline)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    video: ").append(toIndentedString(video)).append("\n");
        sb.append("    voteAverage: ").append(toIndentedString(voteAverage)).append("\n");
        sb.append("    voteCount: ").append(toIndentedString(voteCount)).append("\n");
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

        out.writeValue(adult);

        out.writeValue(backdropPath);

        out.writeValue(budget);

        out.writeValue(genres);

        out.writeValue(homepage);

        out.writeValue(id);

        out.writeValue(imdbId);

        out.writeValue(originalLanguage);

        out.writeValue(originalTitle);

        out.writeValue(overview);

        out.writeValue(popularity);

        out.writeValue(posterPath);

        out.writeValue(productionCompanies);

        out.writeValue(productionCountries);

        out.writeValue(releaseDate);

        out.writeValue(revenue);

        out.writeValue(runtime);

        out.writeValue(spokenLanguages);

        out.writeValue(status);

        out.writeValue(tagline);

        out.writeValue(title);

        out.writeValue(video);

        out.writeValue(voteAverage);

        out.writeValue(voteCount);
    }

    public MovieDetails() {
        super();
    }

    MovieDetails(Parcel in) {

        adult = (Boolean) in.readValue(getClass().getClassLoader());
        backdropPath = (String) in.readValue(getClass().getClassLoader());
        budget = (Integer) in.readValue(getClass().getClassLoader());
        genres = (List<MovieGenre>) in.readValue(MovieGenre.class.getClassLoader());
        homepage = (String) in.readValue(getClass().getClassLoader());
        id = (Integer) in.readValue(getClass().getClassLoader());
        imdbId = (String) in.readValue(getClass().getClassLoader());
        originalLanguage = (String) in.readValue(getClass().getClassLoader());
        originalTitle = (String) in.readValue(getClass().getClassLoader());
        overview = (String) in.readValue(getClass().getClassLoader());
        popularity = (Float) in.readValue(Float.class.getClassLoader());
        posterPath = (String) in.readValue(getClass().getClassLoader());
        productionCompanies = (List<ProductionCompanies>) in.readValue(ProductionCompanies.class.getClassLoader());
        productionCountries = (List<ProductionCountries>) in.readValue(ProductionCountries.class.getClassLoader());
        releaseDate = (Date) in.readValue(Date.class.getClassLoader());
        revenue = (Integer) in.readValue(getClass().getClassLoader());
        runtime = (Integer) in.readValue(getClass().getClassLoader());
        spokenLanguages = (List<SpokenLanguages>) in.readValue(SpokenLanguages.class.getClassLoader());
        status = (String) in.readValue(getClass().getClassLoader());
        tagline = (String) in.readValue(getClass().getClassLoader());
        title = (String) in.readValue(getClass().getClassLoader());
        video = (Boolean) in.readValue(getClass().getClassLoader());
        voteAverage = (Float) in.readValue(Float.class.getClassLoader());
        voteCount = (Integer) in.readValue(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<MovieDetails> CREATOR = new Parcelable.Creator<MovieDetails>() {
        public MovieDetails createFromParcel(Parcel in) {
            return new MovieDetails(in);
        }

        public MovieDetails[] newArray(int size) {
            return new MovieDetails[size];
        }
    };
}
