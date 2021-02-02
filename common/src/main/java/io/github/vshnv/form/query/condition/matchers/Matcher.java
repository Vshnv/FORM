package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;
import java.util.Optional;

public abstract class Matcher {

    protected final Optional<Object> getFieldValue(Field f, Object obj) {
        try {
            return Optional.ofNullable(f.get(obj));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public abstract boolean match(Object fieldObj, Object operand);

}
