package io.github.vshnv.form.serialization.impl;

import io.github.vshnv.form.annotation.PrimaryKey;
import io.github.vshnv.form.serialization.SerializedObject;
import io.github.vshnv.form.serialization.Serializer;
import io.github.vshnv.form.serialization.key.KeyFinder;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
public class ReflectiveSerializer implements Serializer {
    private final KeyFinder keyFinder;
    public ReflectiveSerializer(KeyFinder keyFinder) {
        this.keyFinder = keyFinder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SerializedObject serialize(Object obj) {
        Class<?> clazz = obj.getClass();
        Collector<Field, ?, Map<String, Object>> mapper = Collectors.toMap(Field::getName, f -> getValueFromField(f, obj));
        Map<String, Object> map = Arrays.stream(clazz.getDeclaredFields()).collect(mapper);
        String key = keyFinder.findPrimaryKey(obj).orElseThrow(() -> new IllegalArgumentException("Primary key not provided in " + obj.getClass()));
        return new SerializedObject(key, map);
    }

    private static Object getValueFromField(Field f, Object obj) {
        try {
            return f.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            // TODO:: Add proper logging
            return "INVALID";
        }
    }
}
