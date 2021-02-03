package io.github.vshnv.form.repository;

import io.github.vshnv.form.query.Query;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface Repository<T> {
    /**
     * Queries for data with the given conditions
     * @param query defines the conditions for the query
     * @return Future collection of results for query
     */
    CompletableFuture<Collection<T>> query(Query query);

    /**
     * Deletes matching query
     * @param query defines the conditions for the query
     * @return Future collection of deleted elements
     */
    CompletableFuture<Collection<T>> erase(Query query);

    /**
     * Inserts or updates the element in the repository
     * @param t element being submitted to the repo
     * @return Last value for key of t if any
     */
    CompletableFuture<Optional<T>> submit(T t);
}
