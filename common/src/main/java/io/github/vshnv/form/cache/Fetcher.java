package io.github.vshnv.form.cache;

import io.github.vshnv.form.query.Query;

public interface Fetcher<T> {
    T fetch(Query query);
}
