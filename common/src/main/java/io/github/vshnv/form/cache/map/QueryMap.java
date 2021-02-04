package io.github.vshnv.form.cache.map;

import io.github.vshnv.form.query.Query;
import io.github.vshnv.form.query.condition.Condition;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class QueryMap<V> implements MultiMap<Query, V> {
    private final ConditionMap<V> conditionMap = new ConditionMap<>();
    int size = 0;
    @Override
    public Collection<V> get(Query query) {
        Collection<Condition> conditions = query.getConditions();
        Set<Collection<V>> valueSet = conditions.stream().map(conditionMap::get).collect(Collectors.toSet());
        return intersectOf(valueSet);
    }

    @Override
    public void put(Query query, V v) {
        Collection<Condition> conditions = query.getConditions();
        for (Condition c: conditions) {
            conditionMap.put(c, v);
        }
    }

    @Override
    public boolean containsKey(Query query) {
        Collection<Condition> conditions = query.getConditions();
        for (Condition c: conditions) {
            if (!conditionMap.containsKey(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsValue(V v) {
        return conditionMap.values().contains(v);
    }

    @Override
    public int size() {
        return conditionMap.size();
    }

    private static <V> Set<V> intersectOf(Set<Collection<V>> valueSet) {
        Optional<Collection<V>> minCollection = valueSet.stream().min((a, v) -> v.size());
        if (!minCollection.isPresent()) {
            return new HashSet<>();
        }
        Set<V> intersection = new HashSet<>();
        outer:
        for (V v: minCollection.get()) {
            for (Collection<V> value : valueSet) {
                if (value != minCollection.get() && !value.contains(v)) {
                    continue outer;
                }
            }
            intersection.add(v);
        }
        return intersection;
    }
}
