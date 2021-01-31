package io.github.vshnv.form.query.condition;

import io.github.vshnv.form.query.Operation;
import io.github.vshnv.form.serialization.Serializer;

import java.util.Collection;
import java.util.Map;

public final class Condition {
    private final String field;
    private final Operation operation;
    private final Object operand;

    public Condition(String field, Operation operation, Object operand) {
        this.field = field;
        this.operation = operation;
        this.operand = operand;
    }

    public String getField() {
        return field;
    }

    public Operation getOperation() {
        return operation;
    }

    public Object getOperand() {
        return operand;
    }

    public static Condition fromEntry(Map.Entry<String, Object> entry, Operation operation) {
        return new Condition(entry.getKey(), operation, entry.getValue());
    }

    public static Extractor extractor(Serializer serializer) {
        return new ConditionExtractor(serializer);
    }
    
    public interface Extractor {
        Collection<Condition> extractConditions(Object object);
    }
}
