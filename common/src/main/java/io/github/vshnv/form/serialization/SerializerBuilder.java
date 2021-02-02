package io.github.vshnv.form.serialization;

import io.github.vshnv.form.serialization.key.KeyFinder;

public interface SerializerBuilder {
    Serializer build();
    SerializerBuilder keyFinder(KeyFinder keyFinder);
}
