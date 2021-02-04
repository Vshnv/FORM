package io.github.vshnv.form.cache.map;

import io.github.vshnv.form.query.condition.Condition;

import java.util.*;
import java.util.stream.Collectors;

public class ConditionMap<V> implements MultiMap<Condition, V> {
    private final Map<Condition, Collection<V>> backingMap = new HashMap<>();
    @Override
    public Collection<V> get(Condition condition) {
        return backingMap.getOrDefault(condition, new HashSet<>());
    }

    @Override
    public void put(Condition condition, V v) {
        backingMap.computeIfAbsent(condition, (k) -> new HashSet<>()).add(v);
    }

    public Set<Condition> keys() {
        return backingMap.keySet();
    }

    public Set<V> values() {
        return backingMap.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    @Override
    public boolean containsKey(Condition condition) {
        return backingMap.containsKey(condition);
    }

    @Override
    public boolean containsValue(V v) {
        return values().contains(v);
    }

    @Override
    public int size() {
        return values().size();
    }
}
