package io.github.vshnv.form.serialization.impl;

import com.google.gson.Gson;
import io.github.vshnv.form.serialization.Serializer;
import io.github.vshnv.form.serialization.SerializerBuilder;
import io.github.vshnv.form.serialization.key.KeyFinder;
import io.github.vshnv.form.serialization.key.SimpleKeyFinder;

public final class GsonSerializerBuilder implements SerializerBuilder {
    private Gson gson;
    private KeyFinder keyFinder;

    @Override
    public Serializer build() {
        Gson gsonArg = gson != null ? gson : new Gson();
        KeyFinder keyFinderArg = keyFinder != null ? keyFinder : new SimpleKeyFinder();
        return new GsonSerializer(gsonArg, keyFinderArg);
    }

    @Override
    public SerializerBuilder keyFinder(KeyFinder keyFinder) {
        this.keyFinder = keyFinder;
        return this;
    }
}
