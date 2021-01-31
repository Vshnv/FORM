package io.github.vshnv.form.query;

import io.github.vshnv.form.query.condition.Condition;

import java.util.Collection;

public interface Query {
    Collection<Condition> getConditions();
}
