package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;

public final class LesserMatcher extends ComparisionMatcher {

    @Override
    public boolean match(Object obj, Field f, Object operand) {
        int res = compare(obj, f, operand);
        return res < 0;
    }
}
