package io.github.vshnv.form.query;

import io.github.vshnv.form.query.condition.Condition;
import io.github.vshnv.form.query.condition.ConditionExtractor;
import io.github.vshnv.form.query.condition.Operation;
import io.github.vshnv.form.query.impl.ObjectQuery;
import io.github.vshnv.form.query.impl.SimpleQuery;
import io.github.vshnv.form.serialization.SerializedObject;
import io.github.vshnv.form.serialization.Serializer;
import io.github.vshnv.form.serialization.SerializerFactory;
import io.github.vshnv.form.test.TestObject;
import io.github.vshnv.form.serialization.impl.GsonSerializer;
import io.github.vshnv.form.serialization.impl.ReflectiveSerializer;
import junit.framework.TestCase;

import java.util.Collection;

public class QueryTest extends TestCase {
    public void testSimpleQuery() {
        Query query = new SimpleQuery(
                new Condition("id", Operation.EQUALS, 15.0),
                new Condition("age", Operation.EQUALS, 23.0)
        );

        assertTrue(query.matches(new TestObject(15, "test", 23)));
    }

    public void testObjectSpecificQuery() {
        TestObject testObject = new TestObject(15, "test", 23);
        Condition.Extractor extractor = Condition.extractor(SerializerFactory.withGson().build());
        ObjectQuery query = new ObjectQuery(testObject, extractor);
        assertTrue(query.matches(new TestObject(15, "test", 23)));
    }
}