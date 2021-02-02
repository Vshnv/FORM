package io.github.vshnv.form.query.condition.matchers;

import java.lang.reflect.Field;
import java.util.Optional;

public abstract class Matcher {

    public abstract boolean match(Object fieldObj, Object operand);

}
