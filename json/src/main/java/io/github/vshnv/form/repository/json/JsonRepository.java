package io.github.vshnv.form.repository.json;

import io.github.vshnv.form.repository.Repository;
import io.github.vshnv.form.query.Query;

import java.io.File;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class JsonRepository<T> implements Repository<T> {
    private final File jsonFile;

    public JsonRepository(File jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Override
    public CompletableFuture<Collection<T>> query(Query query) {
        return null;
    }

    @Override
    public CompletableFuture<Collection<T>> erase(Query query) {
        return null;
    }

    @Override
    public CompletableFuture<Optional<T>> submit(T t) {
        return null;
    }
}
