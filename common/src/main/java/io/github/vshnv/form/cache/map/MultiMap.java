package io.github.vshnv.form.cache.map;

import java.util.Collection;

public interface MultiMap<K, V> {
    Collection<V> get(K k);
    void put(K k, V v);
    boolean containsKey(K k);
    boolean containsValue(V v);
    int size();
}
