package io.github.vshnv.form.serialization.key;

import io.github.vshnv.form.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

public class SimpleKeyFinder implements KeyFinder {
    @Override
    public Optional<String> findPrimaryKey(Object obj) {
        Class<?> clazz = obj.getClass();
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.getAnnotation(PrimaryKey.class) != null)
                .map(Field::getName).findFirst();
    }
}
