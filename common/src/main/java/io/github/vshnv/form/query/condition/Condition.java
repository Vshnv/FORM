package io.github.vshnv.form.query.condition;

import io.github.vshnv.form.serialization.Serializer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Represents a specific condition bound
 */
public final class Condition {
    private final String field;
    private final Operation operation;
    private final Object operand;

    public Condition(String field, Operation operation, Object operand) {
        this.field = field;
        this.operation = operation;
        this.operand = operand;
    }

    /**
     * @return name of the field upon whom the condition is defined
     */
    public String getField() {
        return field;
    }

    /**
     * @return operation that the condition uses
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * @return the operand that the field is compared to
     */
    public Object getOperand() {
        return operand;
    }

    /**
     * Gets a Condition based of a map entry with the specified operation
     * @param entry the map entry from the field to the operand, i.e, {Field: Object}
     * @param operation operation to be used in the condition
     * @return Condition based on provided entry
     */
    public static Condition fromEntry(Map.Entry<String, Object> entry, Operation operation) {
        return new Condition(entry.getKey(), operation, entry.getValue());
    }

    /**
     * Provides an extractor that allows us to extract the exact conditions required to match an object
     * @param serializer the serializer to be used to extract the conditions
     * @return Extractor to extract conditions from objects
     */
    public static Extractor extractor(Serializer serializer) {
        return new ConditionExtractor(serializer);
    }

    /**
     * Extractor extracts Conditions matching an Object
     */
    public interface Extractor {
        /**
         * @param object Object whose conditions are to be extracted
         * @return collection of conditions representing given object
         */
        Collection<Condition> extractConditions(Object object);
    }
}
