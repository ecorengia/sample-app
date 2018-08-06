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
 * SpokenLanguages
 */
public final class SpokenLanguages implements Parcelable {
    @SerializedName("iso_639_1")
    private String iso6391 = null;

    @SerializedName("name")
    private String name = null;

    public SpokenLanguages iso6391(String iso6391) {
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

    public SpokenLanguages name(String name) {
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
        SpokenLanguages spokenLanguages = (SpokenLanguages) o;
        return Objects.equals(this.iso6391, spokenLanguages.iso6391) &&
                Objects.equals(this.name, spokenLanguages.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iso6391, name);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SpokenLanguages {\n");

        sb.append("    iso6391: ").append(toIndentedString(iso6391)).append("\n");
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

        out.writeValue(iso6391);

        out.writeValue(name);
    }

    public SpokenLanguages() {
        super();
    }

    SpokenLanguages(Parcel in) {

        iso6391 = (String) in.readValue(getClass().getClassLoader());
        name = (String) in.readValue(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<SpokenLanguages> CREATOR = new Parcelable.Creator<SpokenLanguages>() {
        public SpokenLanguages createFromParcel(Parcel in) {
            return new SpokenLanguages(in);
        }

        public SpokenLanguages[] newArray(int size) {
            return new SpokenLanguages[size];
        }
    };

    /* package */ final static class SpokenLanguagesTypeConverter {
        final static Gson gson = new Gson();

        @TypeConverter
        public static List<SpokenLanguages> stringToSpokenLanguagesList(@Nullable final String data) {
            if (data == null) {
                return Collections.emptyList();
            }

            final Type listType = new TypeToken<List<SpokenLanguages>>() {
            }.getType();

            return gson.fromJson(data, listType);
        }

        @TypeConverter
        public static String spokenLanguagesListToString(List<SpokenLanguages> someObjects) {
            return gson.toJson(someObjects);
        }
    }
}
