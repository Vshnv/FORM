package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;

public final class GreaterEqualsMatcher extends ComparisionMatcher {
    @Override
    public boolean match(Object fieldObj, Object operand) {
        int res = compare(fieldObj, operand);
        return res >= 0;
    }
}
