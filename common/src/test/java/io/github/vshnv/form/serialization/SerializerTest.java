package io.github.vshnv.form.serialization;

import io.github.vshnv.form.test.TestObject;
import io.github.vshnv.form.serialization.impl.GsonSerializer;
import io.github.vshnv.form.serialization.impl.ReflectiveSerializer;
import junit.framework.TestCase;

public class SerializerTest extends TestCase {
    public void testGsonSerializer() {
        Serializer gsonSerializer = SerializerFactory.withGson().build();
        TestObject object = new TestObject(15, "SerializationTest", 23);
        SerializedObject so = gsonSerializer.serialize(object);

        assertEquals(TestObject.EXPECTED_MAP, so.getData());
        assertEquals(so.getPrimaryKey(), "id");
        assertEquals(new SerializedObject("id", TestObject.EXPECTED_MAP), so);
    }

    public void testReflectiveSerializer() {
        Serializer reflectiveSerializer = SerializerFactory.withReflection().build();
        TestObject object = new TestObject(15, "SerializationTest", 23);
        SerializedObject so = reflectiveSerializer.serialize(object);

        assertEquals(TestObject.EXPECTED_MAP, so.getData());
        assertEquals(so.getPrimaryKey(), "id");
        assertEquals(new SerializedObject("id", TestObject.EXPECTED_MAP), so);
    }
}