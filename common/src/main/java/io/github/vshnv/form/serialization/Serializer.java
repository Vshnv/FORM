package io.github.vshnv.form.serialization;

import java.util.Map;

public interface Serializer {
    SerializedObject serialize(Object obj);
}