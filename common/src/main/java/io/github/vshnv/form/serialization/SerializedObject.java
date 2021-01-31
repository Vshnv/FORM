package io.github.vshnv.form.serialization;

import java.util.Map;
import java.util.Objects;

/**
 * Represents the serialized form of an object
 */
public final class SerializedObject {
    // Name of primary key field
    private final String primaryKey;
    // Map of all serialized values in the object
    private final Map<String, Object> data;

    /**
     * @param primaryKey primary key from the given map of data
     * @param data the serialized data from an object
     * @apiNote data must contain the primaryKey as a key
     */
    public SerializedObject(String primaryKey, Map<String, Object> data) {
        this.primaryKey = primaryKey;
        this.data = data;
    }


    public String getPrimaryKey() {
        return primaryKey;
    }

    /**
     * @return Map of serialized data. Key being field names, value being field value
     * @apiNote key might not be ACTUAL field name but rather the field to be used in storage
     */
    public Map<String, Object> getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerializedObject that = (SerializedObject) o;
        return primaryKey.equals(that.primaryKey) &&
                data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryKey, data);
    }
}
