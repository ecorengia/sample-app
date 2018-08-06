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
 * ProductionCountries
 */
public final class ProductionCountries implements Parcelable {
    @SerializedName("iso_3166_1")
    private String iso31661 = null;

    @SerializedName("name")
    private String name = null;

    public ProductionCountries iso31661(String iso31661) {
        this.iso31661 = iso31661;
        return this;
    }

    /**
     * Get iso31661
     *
     * @return iso31661
     **/
    public String getIso31661() {
        return iso31661;
    }

    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
    }

    public ProductionCountries name(String name) {
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
        ProductionCountries productionCountries = (ProductionCountries) o;
        return Objects.equals(this.iso31661, productionCountries.iso31661) &&
                Objects.equals(this.name, productionCountries.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iso31661, name);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductionCountries {\n");

        sb.append("    iso31661: ").append(toIndentedString(iso31661)).append("\n");
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

        out.writeValue(iso31661);

        out.writeValue(name);
    }

    public ProductionCountries() {
        super();
    }

    ProductionCountries(Parcel in) {

        iso31661 = (String) in.readValue(getClass().getClassLoader());
        name = (String) in.readValue(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<ProductionCountries> CREATOR = new Parcelable.Creator<ProductionCountries>() {
        public ProductionCountries createFromParcel(Parcel in) {
            return new ProductionCountries(in);
        }

        public ProductionCountries[] newArray(int size) {
            return new ProductionCountries[size];
        }
    };

    /* package */ final static class ProductionCountriesTypeConverter {
        final static Gson gson = new Gson();

        @TypeConverter
        public static List<ProductionCountries> stringToProductionCountriesList(@Nullable final String data) {
            if (data == null) {
                return Collections.emptyList();
            }

            final Type listType = new TypeToken<List<ProductionCountries>>() {
            }.getType();

            return gson.fromJson(data, listType);
        }

        @TypeConverter
        public static String productionCountriesListToString(List<ProductionCountries> someObjects) {
            return gson.toJson(someObjects);
        }
    }
}
