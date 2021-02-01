package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;
import java.util.Optional;

abstract class ComparisionMatcher extends Matcher {
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected int compare(Object obj, Field f, Object operand) throws ClassCastException {
        Optional<Object> fieldObj = getFieldValue(f, obj);
        return fieldObj.map(o -> {
            Comparable comparable = ((Comparable<?>) o);
            return comparable.compareTo(operand);
        }).orElse(0);
    }
}
