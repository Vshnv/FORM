package io.github.vshnv.form.query.impl;

import io.github.vshnv.form.query.condition.Condition;
import io.github.vshnv.form.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class SimpleQuery implements Query {
    private final List<Condition> conditions;

    public SimpleQuery() {
        this.conditions = new ArrayList<>();
    }

    public SimpleQuery(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public void addCondition(Condition condition) {
        this.conditions.add(condition);
    }

    public void removeCondition(Condition condition) {
        this.conditions.remove(condition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Condition> getConditions() {
        return conditions;
    }
}
