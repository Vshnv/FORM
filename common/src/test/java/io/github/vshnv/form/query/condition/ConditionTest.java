package io.github.vshnv.form.query.condition;

import io.github.vshnv.form.serialization.impl.GsonSerializer;
import io.github.vshnv.form.test.TestObject;
import junit.framework.TestCase;

public class ConditionTest extends TestCase {
    public void testConditionTesting() {
        Condition c = new Condition("id", Operation.EQUALS, 15.0);
        c.test(new TestObject(15, "test", 45), new GsonSerializer());
    }
}