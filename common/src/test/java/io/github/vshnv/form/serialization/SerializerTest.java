package io.github.vshnv.form.serialization;

import io.github.vshnv.form.serialization.impl.GsonSerializer;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class SerializerTest extends TestCase {
    public void testGsonSerializer() {
        Serializer gsonSerializer = new GsonSerializer();
        TestObject object = new TestObject(15, "SerializationTest", 23);
        SerializedObject so = gsonSerializer.serialize(object);

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("id", 15.0);
        expectedMap.put("name", "SerializationTest");
        expectedMap.put("age", 23.0);

        System.out.println(so.getPrimaryKey());
        assertEquals(expectedMap, so.getData());
        assertEquals(so.getPrimaryKey(), "id");
        assertEquals(new SerializedObject("id", expectedMap), so);
    }
}