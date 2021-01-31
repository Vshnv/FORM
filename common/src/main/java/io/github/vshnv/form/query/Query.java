package io.github.vshnv.form.query;

import io.github.vshnv.form.query.condition.Condition;

import java.util.Collection;

/**
 * Fetches a collection of {@link Condition} required for a query
 */
public interface Query {
    /**
     * @return Collection of Conditions that specify the bounds of a query
     */
    Collection<Condition> getConditions();
}
