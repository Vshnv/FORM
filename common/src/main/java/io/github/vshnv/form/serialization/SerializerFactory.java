package io.github.vshnv.form.serialization;

import com.google.gson.Gson;
import io.github.vshnv.form.serialization.impl.GsonSerializer;

public final class SerializerFactory {
    private SerializerFactory() {

    }

    public static Serializer withGson(Gson gson) {
        return new GsonSerializer(gson);
    }
}
