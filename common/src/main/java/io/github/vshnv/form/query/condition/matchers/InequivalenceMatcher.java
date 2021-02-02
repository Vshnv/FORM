package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;

public final class InequivalenceMatcher extends Matcher {


    @Override
    public boolean match(Object fieldObj, Object operand) {
        return !Objects.equals(fieldObj, operand);
    }
}
