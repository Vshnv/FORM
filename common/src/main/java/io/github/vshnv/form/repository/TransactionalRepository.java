package io.github.vshnv.form.repository;

public interface TransactionalRepository<T> extends Repository<T>, AutoCloseable {
}
