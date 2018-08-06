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
 * Maps the images for a collection by id.
 *
 * @see <a href="https://developers.themoviedb.org/3/collections/get-collection-images">get-collection-images</a>
 */
@Entity(tableName = "images_table")
public final class ImageListObject implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int dbId;

    @SerializedName("id")
    private Integer id = null;

    @TypeConverters(ImageBackdrops.ImageBackdropsTypeConverter.class)
    @SerializedName("backdrops")
    private List<ImageBackdrops> backdrops = null;

    @TypeConverters(ImagePosters.ImagePostersTypeConverter.class)
    @SerializedName("posters")
    private List<ImagePosters> posters = null;

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

    public ImageListObject id(Integer id) {
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

    public ImageListObject backdrops(List<ImageBackdrops> backdrops) {
        this.backdrops = backdrops;
        return this;
    }

    public ImageListObject addBackdropsItem(ImageBackdrops backdropsItem) {
        if (this.backdrops == null) {
            this.backdrops = new ArrayList<>();
        }
        this.backdrops.add(backdropsItem);
        return this;
    }

    /**
     * Get backdrops
     *
     * @return backdrops
     **/
    public List<ImageBackdrops> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<ImageBackdrops> backdrops) {
        this.backdrops = backdrops;
    }

    public ImageListObject posters(List<ImagePosters> posters) {
        this.posters = posters;
        return this;
    }

    public ImageListObject addPostersItem(ImagePosters postersItem) {
        if (this.posters == null) {
            this.posters = new ArrayList<>();
        }
        this.posters.add(postersItem);
        return this;
    }

    /**
     * Get posters
     *
     * @return posters
     **/
    public List<ImagePosters> getPosters() {
        return posters;
    }

    public void setPosters(List<ImagePosters> posters) {
        this.posters = posters;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageListObject imageListObject = (ImageListObject) o;
        return Objects.equals(this.id, imageListObject.id) &&
                Objects.equals(this.backdrops, imageListObject.backdrops) &&
                Objects.equals(this.posters, imageListObject.posters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, backdrops, posters);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageListObject {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    backdrops: ").append(toIndentedString(backdrops)).append("\n");
        sb.append("    posters: ").append(toIndentedString(posters)).append("\n");
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

        out.writeValue(backdrops);

        out.writeValue(posters);
    }

    public ImageListObject() {
        super();
    }

    ImageListObject(Parcel in) {

        id = (Integer) in.readValue(getClass().getClassLoader());
        backdrops = (List<ImageBackdrops>) in.readValue(ImageBackdrops.class.getClassLoader());
        posters = (List<ImagePosters>) in.readValue(ImagePosters.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<ImageListObject> CREATOR = new Parcelable.Creator<ImageListObject>() {
        public ImageListObject createFromParcel(Parcel in) {
            return new ImageListObject(in);
        }

        public ImageListObject[] newArray(int size) {
            return new ImageListObject[size];
        }
    };
}
