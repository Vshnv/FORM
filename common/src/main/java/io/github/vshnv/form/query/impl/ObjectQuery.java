package io.github.vshnv.form.query.impl;

import io.github.vshnv.form.query.condition.Condition;
import io.github.vshnv.form.query.Query;
import io.github.vshnv.form.serialization.Serializer;
import io.github.vshnv.form.serialization.SerializerFactory;
import io.github.vshnv.form.serialization.impl.GsonSerializer;

import java.util.Collection;

/**
 * {@inheritDoc}
 */
public class ObjectQuery implements Query {
    private final Object object;
    private final Condition.Extractor extractor;
    private final Serializer serializer;

    public ObjectQuery(Object object, Condition.Extractor extractor) {
        this(object, extractor, SerializerFactory.withGson().build());
    }

    public ObjectQuery(Object object, Condition.Extractor extractor, Serializer serializer) {
        this.object = object;
        this.extractor = extractor;
        this.serializer = serializer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Condition> getConditions() {
        return extractor.extractConditions(object);
    }

    @Override
    public boolean matches(Object obj) {

        return getConditions().stream().allMatch(c -> c.test(obj, serializer));
    }
}
