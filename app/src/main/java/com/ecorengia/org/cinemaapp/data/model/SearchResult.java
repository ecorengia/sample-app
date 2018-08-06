package com.ecorengia.org.cinemaapp.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Maps the search result for movies.
 *
 * @see <a href="https://developers.themoviedb.org/3/search/search-movies">search-movies</a>
 */
@Entity(tableName = "search_results")
public final class SearchResult implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int dbId;

    @SerializedName("page")
    private Integer page = null;

    @TypeConverters(MovieListObject.MovieListObjectTypeConverter.class)
    @SerializedName("results")
    private List<MovieListObject> results = null;

    @SerializedName("total_results")
    private Integer totalResults = null;

    @SerializedName("total_pages")
    private Integer totalPages = null;

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

    public SearchResult page(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * Get page
     *
     * @return page
     **/
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public SearchResult results(List<MovieListObject> results) {
        this.results = results;
        return this;
    }

    public SearchResult addResultsItem(MovieListObject resultsItem) {
        if (this.results == null) {
            this.results = new ArrayList<>();
        }
        this.results.add(resultsItem);
        return this;
    }

    /**
     * Get results
     *
     * @return results
     **/
    public List<MovieListObject> getResults() {
        return results;
    }

    public void setResults(List<MovieListObject> results) {
        this.results = results;
    }

    public SearchResult totalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    /**
     * Get totalResults
     *
     * @return totalResults
     **/
    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public SearchResult totalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    /**
     * Get totalPages
     *
     * @return totalPages
     **/
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchResult searchResult = (SearchResult) o;
        return Objects.equals(this.page, searchResult.page) &&
                Objects.equals(this.results, searchResult.results) &&
                Objects.equals(this.totalResults, searchResult.totalResults) &&
                Objects.equals(this.totalPages, searchResult.totalPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, results, totalResults, totalPages);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SearchResult {\n");

        sb.append("    page: ").append(toIndentedString(page)).append("\n");
        sb.append("    results: ").append(toIndentedString(results)).append("\n");
        sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
        sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
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

        out.writeValue(page);

        out.writeValue(results);

        out.writeValue(totalResults);

        out.writeValue(totalPages);
    }

    public SearchResult() {
        super();
    }

    SearchResult(Parcel in) {

        page = (Integer) in.readValue(getClass().getClassLoader());
        results = (List<MovieListObject>) in.readValue(MovieListObject.class.getClassLoader());
        totalResults = (Integer) in.readValue(getClass().getClassLoader());
        totalPages = (Integer) in.readValue(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<SearchResult> CREATOR = new Parcelable.Creator<SearchResult>() {
        public SearchResult createFromParcel(Parcel in) {
            return new SearchResult(in);
        }

        public SearchResult[] newArray(int size) {
            return new SearchResult[size];
        }
    };
}
