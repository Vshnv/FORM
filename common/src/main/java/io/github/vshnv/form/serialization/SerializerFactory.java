package io.github.vshnv.form.serialization;

import com.google.gson.Gson;
import io.github.vshnv.form.serialization.impl.GsonSerializer;
import io.github.vshnv.form.serialization.impl.GsonSerializerBuilder;
import io.github.vshnv.form.serialization.impl.ReflectiveSerializer;
import io.github.vshnv.form.serialization.impl.ReflectiveSerializerBuilder;

public final class SerializerFactory {
    private SerializerFactory() {
    }

    public static SerializerBuilder withGson() {
        return new GsonSerializerBuilder();
    }

    public static SerializerBuilder withReflection() {
        return new ReflectiveSerializerBuilder();
    }
}
