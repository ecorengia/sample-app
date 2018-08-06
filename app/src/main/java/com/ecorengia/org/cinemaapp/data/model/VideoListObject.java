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
 * Maps the videos that have been added to a movie.
 *
 * @see <a href="https://developers.themoviedb.org/3/movies/get-movie-videos">get-movie-videos</a>
 */
@Entity(tableName = "videos_table")
public final class VideoListObject implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int dbId;

    @SerializedName("id")
    private Integer id = null;

    @TypeConverters(VideoResult.VideoResultTypeConverter.class)
    @SerializedName("results")
    private List<VideoResult> results = null;

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

    public VideoListObject id(Integer id) {
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

    public VideoListObject results(List<VideoResult> results) {
        this.results = results;
        return this;
    }

    public VideoListObject addResultsItem(VideoResult resultsItem) {
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
    public List<VideoResult> getResults() {
        return results;
    }

    public void setResults(List<VideoResult> results) {
        this.results = results;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VideoListObject videoListObject = (VideoListObject) o;
        return Objects.equals(this.id, videoListObject.id) &&
                Objects.equals(this.results, videoListObject.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, results);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VideoListObject {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

        out.writeValue(id);

        out.writeValue(results);
    }

    public VideoListObject() {
        super();
    }

    VideoListObject(Parcel in) {

        id = (Integer) in.readValue(getClass().getClassLoader());
        results = (List<VideoResult>) in.readValue(VideoResult.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<VideoListObject> CREATOR = new Parcelable.Creator<VideoListObject>() {
        public VideoListObject createFromParcel(Parcel in) {
            return new VideoListObject(in);
        }

        public VideoListObject[] newArray(int size) {
            return new VideoListObject[size];
        }
    };
}
