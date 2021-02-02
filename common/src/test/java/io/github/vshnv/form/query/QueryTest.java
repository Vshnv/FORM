package io.github.vshnv.form.query;

import io.github.vshnv.form.query.condition.Condition;
import io.github.vshnv.form.query.condition.Operation;
import io.github.vshnv.form.query.impl.SimpleQuery;
import io.github.vshnv.form.serialization.SerializedObject;
import io.github.vshnv.form.serialization.Serializer;
import io.github.vshnv.form.test.TestObject;
import io.github.vshnv.form.serialization.impl.GsonSerializer;
import io.github.vshnv.form.serialization.impl.ReflectiveSerializer;
import junit.framework.TestCase;

public class QueryTest extends TestCase {
    public void testSimpleQuery() {
        Query query = new SimpleQuery(
                new Condition("id", Operation.EQUALS, 15.0),
                new Condition("age", Operation.EQUALS, 23.0)
        );

        assertTrue(query.matches(new TestObject(15, "test", 23)));
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