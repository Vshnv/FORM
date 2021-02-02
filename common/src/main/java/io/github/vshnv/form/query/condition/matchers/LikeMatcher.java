package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;

public class LikeMatcher extends Matcher {
    @Override
    public boolean match(Object fieldObj, Object operand) {
        String regex = operand.toString().replace("%", ".*");
        return fieldObj.toString().matches(regex);
    }
}
