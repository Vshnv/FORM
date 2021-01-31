package io.github.vshnv.form;

import java.util.concurrent.CompletableFuture;

public interface Repository<T> {
    CompletableFuture<T> query(Query<T> query);
    CompletableFuture<Boolean> submit(T t);
    CompletableFuture<Boolean> delete(T t);
}
