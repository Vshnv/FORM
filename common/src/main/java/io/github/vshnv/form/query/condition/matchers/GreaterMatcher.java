package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;

public final class GreaterMatcher extends ComparisionMatcher {
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public boolean match(Object fieldObj, Object operand) throws ClassCastException {
        int res = compare(fieldObj, operand);
        return res > 0;
    }
}
