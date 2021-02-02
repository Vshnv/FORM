package io.github.vshnv.form.query.condition.matchers;

import io.github.vshnv.form.query.Range;

import java.lang.reflect.Field;

public class BetweenMatcher extends Matcher {
    @Override
    public boolean match(Object fieldObj, Object operand) {
        if (operand instanceof Range && fieldObj instanceof Number) {
            return ((Range<?>) operand).includes((Number) fieldObj);
        }
        return false;
    }
}
