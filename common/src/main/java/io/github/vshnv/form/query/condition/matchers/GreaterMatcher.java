package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;

public final class GreaterMatcher extends ComparisionMatcher {
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public boolean match(Object obj, Field f, Object operand) throws ClassCastException {
        int res = compare(obj, f, operand);
        return res > 0;
    }
}
