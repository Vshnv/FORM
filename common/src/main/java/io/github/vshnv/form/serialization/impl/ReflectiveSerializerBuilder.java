package io.github.vshnv.form.serialization.impl;

import com.google.gson.Gson;
import io.github.vshnv.form.serialization.Serializer;
import io.github.vshnv.form.serialization.SerializerBuilder;
import io.github.vshnv.form.serialization.key.KeyFinder;
import io.github.vshnv.form.serialization.key.SimpleKeyFinder;

public class ReflectiveSerializerBuilder implements SerializerBuilder {
    private KeyFinder keyFinder;

    @Override
    public Serializer build() {
        KeyFinder keyFinderArg = keyFinder != null ? keyFinder : new SimpleKeyFinder();
        return new ReflectiveSerializer(keyFinderArg);
    }

    @Override
    public SerializerBuilder keyFinder(KeyFinder keyFinder) {
        this.keyFinder = keyFinder;
        return this;
    }
}
