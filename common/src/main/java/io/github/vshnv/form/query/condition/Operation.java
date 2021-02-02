package io.github.vshnv.form.query.condition;

import io.github.vshnv.form.query.condition.matchers.*;

import java.util.function.Supplier;

/**
 * Operations to be used by {@link io.github.vshnv.form.query.condition.Condition} on a field
 */
public enum Operation {
    EQUALS(EquivalenceMatcher::new),
    NOT_EQUALS(InequivalenceMatcher::new),
    GREATER(GreaterMatcher::new),
    GREATER_OR_EQUAL(GreaterEqualsMatcher::new),
    LESSER(LesserMatcher::new),
    LESSER_OR_EQUAL(LesserEqualsMatcher::new),
    BETWEEN(BetweenMatcher::new),
    LIKE(LikeMatcher::new),
    IN(InMatcher::new);
    private final Supplier<Matcher> matcherSupplier;
    Operation(Supplier<Matcher> matcherSupplier) {
        this.matcherSupplier = matcherSupplier;
    }
}
