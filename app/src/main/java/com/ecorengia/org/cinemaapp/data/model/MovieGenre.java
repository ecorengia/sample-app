package com.ecorengia.org.cinemaapp.data.model;

import android.arch.persistence.room.TypeConverter;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * MovieGenre
 */
public final class MovieGenre implements Parcelable {
    @SerializedName("id")
    private Integer id = null;

    @SerializedName("name")
    private String name = null;

    public MovieGenre id(Integer id) {
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

    public MovieGenre name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovieGenre movieGenre = (MovieGenre) o;
        return Objects.equals(this.id, movieGenre.id) &&
                Objects.equals(this.name, movieGenre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MovieGenre {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

        out.writeValue(name);
    }

    public MovieGenre() {
        super();
    }

    MovieGenre(Parcel in) {

        id = (Integer) in.readValue(getClass().getClassLoader());
        name = (String) in.readValue(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<MovieGenre> CREATOR = new Parcelable.Creator<MovieGenre>() {
        public MovieGenre createFromParcel(Parcel in) {
            return new MovieGenre(in);
        }

        public MovieGenre[] newArray(int size) {
            return new MovieGenre[size];
        }
    };

    /* package */ final static class MovieGenreTypeConverter {
        final static Gson gson = new Gson();

        @TypeConverter
        public static List<MovieGenre> stringToMovieGenreList(@Nullable final String data) {
            if (data == null) {
                return Collections.emptyList();
            }

            final Type listType = new TypeToken<List<MovieGenre>>() {
            }.getType();

            return gson.fromJson(data, listType);
        }

        @TypeConverter
        public static String movieGenreListToString(List<MovieGenre> someObjects) {
            return gson.toJson(someObjects);
        }
    }
}
