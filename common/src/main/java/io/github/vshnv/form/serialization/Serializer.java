package io.github.vshnv.form.serialization;

/**
 * Converts an object to a {@link SerializedObject} based on annotation hints
 */
public interface Serializer {
    /**
     * Creates a internal serialized representation of the object
     * @param obj Object to be serialized
     * @return Serialized version of the object with map of data and key
     * @apiNote Object must have a field annotated with {@link io.github.vshnv.form.annotation.PrimaryKey}
     */
    SerializedObject serialize(Object obj);
}