package io.github.vshnv.form.serialization;

import java.util.Map;

public final class SerializedObject {
    private final String primaryKey;
    private final Map<String, Object> data;

    public SerializedObject(String primaryKey, Map<String, Object> data) {
        this.primaryKey = primaryKey;
        this.data = data;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
