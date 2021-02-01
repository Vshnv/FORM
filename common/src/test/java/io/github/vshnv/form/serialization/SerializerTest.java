package io.github.vshnv.form.serialization;

import io.github.vshnv.form.serialization.impl.GsonSerializer;
import io.github.vshnv.form.serialization.impl.ReflectiveSerializer;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class SerializerTest extends TestCase {
    public void testGsonSerializer() {
        Serializer gsonSerializer = new GsonSerializer();
        TestObject object = new TestObject(15, "SerializationTest", 23);
        SerializedObject so = gsonSerializer.serialize(object);


        assertEquals(TestObject.EXPECTED_MAP, so.getData());
        assertEquals(so.getPrimaryKey(), "id");
        assertEquals(new SerializedObject("id", TestObject.EXPECTED_MAP), so);
    }

    public void testReflectiveSerializer() {
        Serializer reflectiveSerializer = new ReflectiveSerializer();
        TestObject object = new TestObject(15, "SerializationTest", 23);
        SerializedObject so = reflectiveSerializer.serialize(object);


        assertEquals(TestObject.EXPECTED_MAP, so.getData());
        assertEquals(so.getPrimaryKey(), "id");
        assertEquals(new SerializedObject("id", TestObject.EXPECTED_MAP), so);
    }
}