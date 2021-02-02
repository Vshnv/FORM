package io.github.vshnv.form.query.impl;

import io.github.vshnv.form.query.condition.Condition;
import io.github.vshnv.form.query.Query;
import io.github.vshnv.form.serialization.Serializer;
import io.github.vshnv.form.serialization.impl.GsonSerializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class SimpleQuery implements Query {
    private final Collection<Condition> conditions;
    private final Serializer serializer;

    public SimpleQuery(Condition... conditions) {
        this(Arrays.asList(conditions));
    }

    public SimpleQuery(Collection<Condition> conditions) {
       this(conditions, new GsonSerializer());
    }

    public SimpleQuery(Collection<Condition> conditions, Serializer serializer) {
        this.conditions = new ArrayList<>(conditions);
        this.serializer = serializer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Condition> getConditions() {
        return conditions;
    }

    @Override
    public boolean matches(Object obj) {
        return getConditions().stream().allMatch(c -> c.test(obj, serializer));
    }
}
