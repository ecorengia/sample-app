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
 * ProductionCompanies
 */
public final class ProductionCompanies implements Parcelable {
    @SerializedName("name")
    private String name = null;

    @SerializedName("id")
    private Integer id = null;

    public ProductionCompanies name(String name) {
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

    public ProductionCompanies id(Integer id) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductionCompanies productionCompanies = (ProductionCompanies) o;
        return Objects.equals(this.name, productionCompanies.name) &&
                Objects.equals(this.id, productionCompanies.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductionCompanies {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

        out.writeValue(name);

        out.writeValue(id);
    }

    public ProductionCompanies() {
        super();
    }

    ProductionCompanies(Parcel in) {

        name = (String) in.readValue(getClass().getClassLoader());
        id = (Integer) in.readValue(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<ProductionCompanies> CREATOR = new Parcelable.Creator<ProductionCompanies>() {
        public ProductionCompanies createFromParcel(Parcel in) {
            return new ProductionCompanies(in);
        }

        public ProductionCompanies[] newArray(int size) {
            return new ProductionCompanies[size];
        }
    };

    /* package */ final static class ProductionCompaniesTypeConverter {
        final static Gson gson = new Gson();

        @TypeConverter
        public static List<ProductionCompanies> stringToProductionCompaniesList(@Nullable final String data) {
            if (data == null) {
                return Collections.emptyList();
            }

            final Type listType = new TypeToken<List<ProductionCompanies>>() {
            }.getType();

            return gson.fromJson(data, listType);
        }

        @TypeConverter
        public static String productionCompaniesListToString(List<ProductionCompanies> someObjects) {
            return gson.toJson(someObjects);
        }
    }
}
