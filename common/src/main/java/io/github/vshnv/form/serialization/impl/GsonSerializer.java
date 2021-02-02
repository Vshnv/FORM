package io.github.vshnv.form.serialization.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.vshnv.form.serialization.SerializedObject;
import io.github.vshnv.form.serialization.Serializer;
import io.github.vshnv.form.serialization.key.KeyFinder;
import io.github.vshnv.form.serialization.key.SimpleKeyFinder;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * {@inheritDoc}
 */
public class GsonSerializer implements Serializer {
    private static final Type RESULT_TYPE = new TypeToken<Map<String, Object>>(){}.getType();

    private final Gson gson;
    private final KeyFinder keyFinder;

    public GsonSerializer(Gson gson, KeyFinder keyFinder) {
        this.gson = gson;
        this.keyFinder = keyFinder;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public SerializedObject serialize(Object obj) {
        Map<String, Object> map = gson.fromJson(gson.toJsonTree(obj), RESULT_TYPE);

        String key = keyFinder.findPrimaryKey(obj).orElseThrow(() -> new IllegalArgumentException("Primary key not provided in " + obj.getClass()));

        return new SerializedObject(key, map);
    }
}
