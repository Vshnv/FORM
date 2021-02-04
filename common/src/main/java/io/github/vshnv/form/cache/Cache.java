package io.github.vshnv.form.cache;

import io.github.vshnv.form.query.Query;

public interface Cache<T> {
    T get(Query query);
}
