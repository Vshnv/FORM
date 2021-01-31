package io.github.vshnv.form.query.condition;

import io.github.vshnv.form.query.Operation;
import io.github.vshnv.form.serialization.SerializedObject;
import io.github.vshnv.form.serialization.Serializer;

import java.util.Collection;
import java.util.stream.Collectors;

public final class ConditionExtractor implements Condition.Extractor {
    private final Serializer serializer;

    public ConditionExtractor(Serializer serializer) {
        this.serializer = serializer;
    }

    public Collection<Condition> extractConditions(Object object) {
        SerializedObject serializedObject = serializer.serialize(object);
        return serializedObject.getData().entrySet().stream()
                .map(e -> new Condition(e.getKey(), Operation.EQUALS,e.getValue())).collect(Collectors.toList());
    }
}
