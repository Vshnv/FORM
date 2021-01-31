package io.github.vshnv.form.query.condition;

/**
 * Operations to be used by {@link io.github.vshnv.form.query.condition.Condition} on a field
 */
public enum Operation {
    EQUALS,
    NOT_EQUALS,
    GREATER,
    GREATER_OR_EQUAL,
    LESSER,
    LESSER_OR_EQUAL,
    BETWEEN,
    LIKE,
    IN;
}
