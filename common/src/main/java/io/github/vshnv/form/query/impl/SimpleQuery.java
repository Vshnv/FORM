package io.github.vshnv.form.query.impl;

import io.github.vshnv.form.query.condition.Condition;
import io.github.vshnv.form.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class SimpleQuery implements Query {
    private final List<Condition> conditions;

    public SimpleQuery(Condition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public SimpleQuery(List<Condition> conditions) {
        this.conditions = new ArrayList<>(conditions);
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
        return false;
    }
}
