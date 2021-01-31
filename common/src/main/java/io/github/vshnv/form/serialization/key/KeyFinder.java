package io.github.vshnv.form.serialization.key;

import java.util.Optional;

public interface KeyFinder {
    Optional<String> findPrimaryKey(Object obj);
}
