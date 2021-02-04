package io.github.vshnv.form.repository;

public interface CommittableRepository<T> extends Repository<T> {
    void commit();
    void rollback();
}
