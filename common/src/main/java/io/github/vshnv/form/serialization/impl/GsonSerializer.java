package io.github.vshnv.form.serialization.impl;

import com.google.gson.Gson;
import io.github.vshnv.form.serialization.SerializedObject;
import io.github.vshnv.form.serialization.Serializer;
import io.github.vshnv.form.serialization.key.KeyFinder;
import io.github.vshnv.form.serialization.key.SimpleKeyFinder;

import java.util.Map;
import java.util.Optional;

public class GsonSerializer implements Serializer {
    private final Gson gson;
    private final KeyFinder keyFinder;

    public GsonSerializer() {
        this(new Gson(), new SimpleKeyFinder());
    }

    public GsonSerializer(Gson gson, KeyFinder keyFinder) {
        this.gson = gson;
        this.keyFinder = keyFinder;
    }

    @Override
    public SerializedObject serialize(Object obj) {
        Map<String, Object> map = gson.fromJson(gson.toJsonTree(obj), Map.class);

        String key = keyFinder.findPrimaryKey(obj).orElseThrow(() -> new IllegalArgumentException("Primary key not provided in " + obj.getClass()));

        return new SerializedObject(key, map);
    }
}
