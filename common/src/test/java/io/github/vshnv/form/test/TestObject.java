package io.github.vshnv.form.test;

import io.github.vshnv.form.annotation.PrimaryKey;

import java.util.HashMap;
import java.util.Map;

public class TestObject {

    public static Map<String, Object> EXPECTED_MAP = new HashMap<>();
    static {
        EXPECTED_MAP.put("id", 15.0);
        EXPECTED_MAP.put("name", "SerializationTest");
        EXPECTED_MAP.put("age", 23.0);
    }

    @PrimaryKey
    private final int id;
    private String name;
    private int age;

    public TestObject(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
