package io.github.vshnv.form.query.impl;

import io.github.vshnv.form.query.condition.Condition;
import io.github.vshnv.form.query.Query;

import java.util.Collection;

/**
 * {@inheritDoc}
 */
public class ObjectQuery implements Query {
    private final Object object;
    private final Condition.Extractor extractor;

    public ObjectQuery(Object object, Condition.Extractor extractor) {
        this.object = object;
        this.extractor = extractor;
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
        return false;
    }
}
