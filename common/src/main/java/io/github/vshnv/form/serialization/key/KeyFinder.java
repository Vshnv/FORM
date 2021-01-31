package io.github.vshnv.form.serialization.key;

import java.util.Optional;

/**
 * Finds name of first field annotated with {@link io.github.vshnv.form.annotation.PrimaryKey} from a given object
 */
public interface KeyFinder {
    Optional<String> findPrimaryKey(Object obj);
}
