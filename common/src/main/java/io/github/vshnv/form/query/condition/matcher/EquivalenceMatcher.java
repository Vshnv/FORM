package io.github.vshnv.form.query.condition.matcher;

import io.github.vshnv.form.query.condition.Condition;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

public class EquivalenceMatcher extends Matcher {
    @Override
    public boolean match(Object obj, Field f, Object operand) {
        Optional<Object> fieldObj = getFieldValue(f, obj);
        return fieldObj.map(a -> a.equals(operand)).orElse(false);
    }
}
