package io.github.vshnv.form.query.condition.matchers;

import io.github.vshnv.form.query.Range;

import java.lang.reflect.Field;

public class BetweenMatcher extends Matcher {
    @Override
    public boolean match(Object obj, Field f, Object operand) {
        if (operand instanceof Range && obj instanceof Number) {
            return ((Range<?>) operand).includes((Number) obj);
        }
        return false;
    }
}
