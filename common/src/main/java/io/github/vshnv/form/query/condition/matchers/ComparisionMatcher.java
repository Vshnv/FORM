package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;
import java.util.Optional;

abstract class ComparisionMatcher extends Matcher {
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected int compare(Object fieldObj, Object operand) throws ClassCastException {
        Comparable comparable = ((Comparable<?>) fieldObj);
        return comparable.compareTo(operand);
    }
}
