package com.ecorengia.org.cinemaapp.data.model;

import android.arch.persistence.room.TypeConverter;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * VideoResult
 */
public final class VideoResult implements Parcelable {
    @SerializedName("id")
    private String id = null;

    @SerializedName("iso_639_1")
    private String iso6391 = null;

    @SerializedName("iso_3166_1")
    private String iso31661 = null;

    @SerializedName("key")
    private String key = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("site")
    private String site = null;

    @SerializedName("size")
    private Integer size = null;

    /**
     * Gets or Sets type
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        TRAILER("Trailer"),

        TEASER("Teaser"),

        CLIP("Clip"),

        FEATURETTE("Featurette");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TypeEnum fromValue(String text) {
            for (TypeEnum b : TypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("type")
    private TypeEnum type = null;

    public VideoResult id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VideoResult iso6391(String iso6391) {
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

    public VideoResult iso31661(String iso31661) {
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

    public VideoResult key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Get key
     *
     * @return key
     **/
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public VideoResult name(String name) {
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

    public VideoResult site(String site) {
        this.site = site;
        return this;
    }

    /**
     * Get site
     *
     * @return site
     **/
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public VideoResult size(Integer size) {
        this.size = size;
        return this;
    }

    /**
     * Get size
     *
     * @return size
     **/
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public VideoResult type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VideoResult videoResult = (VideoResult) o;
        return Objects.equals(this.id, videoResult.id) &&
                Objects.equals(this.iso6391, videoResult.iso6391) &&
                Objects.equals(this.iso31661, videoResult.iso31661) &&
                Objects.equals(this.key, videoResult.key) &&
                Objects.equals(this.name, videoResult.name) &&
                Objects.equals(this.site, videoResult.site) &&
                Objects.equals(this.size, videoResult.size) &&
                Objects.equals(this.type, videoResult.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iso6391, iso31661, key, name, site, size, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VideoResult {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    iso6391: ").append(toIndentedString(iso6391)).append("\n");
        sb.append("    iso31661: ").append(toIndentedString(iso31661)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    site: ").append(toIndentedString(site)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

        out.writeValue(iso6391);

        out.writeValue(iso31661);

        out.writeValue(key);

        out.writeValue(name);

        out.writeValue(site);

        out.writeValue(size);

        out.writeValue(type);
    }

    public VideoResult() {
        super();
    }

    VideoResult(Parcel in) {

        id = (String) in.readValue(getClass().getClassLoader());
        iso6391 = (String) in.readValue(getClass().getClassLoader());
        iso31661 = (String) in.readValue(getClass().getClassLoader());
        key = (String) in.readValue(getClass().getClassLoader());
        name = (String) in.readValue(getClass().getClassLoader());
        site = (String) in.readValue(getClass().getClassLoader());
        size = (Integer) in.readValue(getClass().getClassLoader());
        type = (TypeEnum) in.readValue(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<VideoResult> CREATOR = new Parcelable.Creator<VideoResult>() {
        public VideoResult createFromParcel(Parcel in) {
            return new VideoResult(in);
        }

        public VideoResult[] newArray(int size) {
            return new VideoResult[size];
        }
    };

    /* package */ final static class VideoResultTypeConverter {
        final static Gson gson = new Gson();

        @TypeConverter
        public static List<VideoResult> stringToVideoResultList(@Nullable final String data) {
            if (data == null) {
                return Collections.emptyList();
            }

            final Type listType = new TypeToken<List<VideoResult>>() {
            }.getType();

            return gson.fromJson(data, listType);
        }

        @TypeConverter
        public static String videoResultListToString(List<VideoResult> someObjects) {
            return gson.toJson(someObjects);
        }
    }
}
