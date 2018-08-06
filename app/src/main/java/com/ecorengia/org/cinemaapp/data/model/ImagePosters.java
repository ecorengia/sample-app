package com.ecorengia.org.cinemaapp.data.model;

import android.arch.persistence.room.TypeConverter;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * ImagePosters
 */
public final class ImagePosters implements Parcelable {
    @SerializedName("aspect_ratio")
    private BigDecimal aspectRatio = null;

    @SerializedName("file_path")
    private String filePath = null;

    @SerializedName("height")
    private Integer height = null;

    @SerializedName("iso_639_1")
    private String iso6391 = null;

    @SerializedName("vote_average")
    private Integer voteAverage = null;

    @SerializedName("vote_count")
    private Integer voteCount = null;

    @SerializedName("width")
    private Integer width = null;

    public ImagePosters aspectRatio(BigDecimal aspectRatio) {
        this.aspectRatio = aspectRatio;
        return this;
    }

    /**
     * Get aspectRatio
     *
     * @return aspectRatio
     **/
    public BigDecimal getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(BigDecimal aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public ImagePosters filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    /**
     * Get filePath
     *
     * @return filePath
     **/
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ImagePosters height(Integer height) {
        this.height = height;
        return this;
    }

    /**
     * Get height
     *
     * @return height
     **/
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public ImagePosters iso6391(String iso6391) {
        this.iso6391 = iso6391;
        return this;
    }

    /**
     * Get iso6391
     *
     * @return iso6391
     **/
    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public ImagePosters voteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    /**
     * Get voteAverage
     *
     * @return voteAverage
     **/
    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public ImagePosters voteCount(Integer voteCount) {
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

    public ImagePosters width(Integer width) {
        this.width = width;
        return this;
    }

    /**
     * Get width
     *
     * @return width
     **/
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImagePosters imagePosters = (ImagePosters) o;
        return Objects.equals(this.aspectRatio, imagePosters.aspectRatio) &&
                Objects.equals(this.filePath, imagePosters.filePath) &&
                Objects.equals(this.height, imagePosters.height) &&
                Objects.equals(this.iso6391, imagePosters.iso6391) &&
                Objects.equals(this.voteAverage, imagePosters.voteAverage) &&
                Objects.equals(this.voteCount, imagePosters.voteCount) &&
                Objects.equals(this.width, imagePosters.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aspectRatio, filePath, height, iso6391, voteAverage, voteCount, width);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImagePosters {\n");

        sb.append("    aspectRatio: ").append(toIndentedString(aspectRatio)).append("\n");
        sb.append("    filePath: ").append(toIndentedString(filePath)).append("\n");
        sb.append("    height: ").append(toIndentedString(height)).append("\n");
        sb.append("    iso6391: ").append(toIndentedString(iso6391)).append("\n");
        sb.append("    voteAverage: ").append(toIndentedString(voteAverage)).append("\n");
        sb.append("    voteCount: ").append(toIndentedString(voteCount)).append("\n");
        sb.append("    width: ").append(toIndentedString(width)).append("\n");
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

        out.writeValue(aspectRatio);

        out.writeValue(filePath);

        out.writeValue(height);

        out.writeValue(iso6391);

        out.writeValue(voteAverage);

        out.writeValue(voteCount);

        out.writeValue(width);
    }

    public ImagePosters() {
        super();
    }

    ImagePosters(Parcel in) {

        aspectRatio = (BigDecimal) in.readValue(BigDecimal.class.getClassLoader());
        filePath = (String) in.readValue(getClass().getClassLoader());
        height = (Integer) in.readValue(getClass().getClassLoader());
        iso6391 = (String) in.readValue(getClass().getClassLoader());
        voteAverage = (Integer) in.readValue(getClass().getClassLoader());
        voteCount = (Integer) in.readValue(getClass().getClassLoader());
        width = (Integer) in.readValue(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<ImagePosters> CREATOR = new Parcelable.Creator<ImagePosters>() {
        public ImagePosters createFromParcel(Parcel in) {
            return new ImagePosters(in);
        }

        public ImagePosters[] newArray(int size) {
            return new ImagePosters[size];
        }
    };

    /* package */ final static class ImagePostersTypeConverter {
        final static Gson gson = new Gson();

        @TypeConverter
        public static List<ImagePosters> stringToImagePostersList(@Nullable final String data) {
            if (data == null) {
                return Collections.emptyList();
            }

            final Type listType = new TypeToken<List<ImagePosters>>() {
            }.getType();

            return gson.fromJson(data, listType);
        }

        @TypeConverter
        public static String imagePostersListToString(List<ImagePosters> someObjects) {
            return gson.toJson(someObjects);
        }
    }
}
