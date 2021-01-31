package io.github.vshnv.form.query.condition;

import io.github.vshnv.form.serialization.SerializedObject;
import io.github.vshnv.form.serialization.Serializer;

import java.util.Collection;
import java.util.stream.Collectors;
/**
 * {@inheritDoc}
 */
public final class ConditionExtractor implements Condition.Extractor {
    private final Serializer serializer;

    public ConditionExtractor(Serializer serializer) {
        this.serializer = serializer;
    }

    /**
     * {@inheritDoc}
     */
    public Collection<Condition> extractConditions(Object object) {
        SerializedObject serializedObject = serializer.serialize(object);
        return serializedObject.getData().entrySet().stream()
                .map(e -> Condition.fromEntry(e, Operation.EQUALS))
                .collect(Collectors.toList());
    }
}
