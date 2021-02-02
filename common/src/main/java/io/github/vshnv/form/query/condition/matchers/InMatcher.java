package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Optional;

public class InMatcher extends Matcher {
    @Override
    public boolean match(Object fieldObj, Object operand) {
        if (operand instanceof Collection) {
            return ((Collection<?>) operand).contains(fieldObj);
        } else {
            return operand.equals(fieldObj);
        }
    }
}
