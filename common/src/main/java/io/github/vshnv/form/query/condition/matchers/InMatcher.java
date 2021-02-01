package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Optional;

public class InMatcher extends Matcher {
    @Override
    public boolean match(Object obj, Field f, Object operand) {
        Optional<Object> fieldValueOptional = getFieldValue(f, obj);
        if (!fieldValueOptional.isPresent()) return false;
        Object value = fieldValueOptional.get();
        if (operand instanceof Collection) {
            return ((Collection<?>) operand).contains(value);
        } else {
            return operand.equals(value);
        }
    }
}
