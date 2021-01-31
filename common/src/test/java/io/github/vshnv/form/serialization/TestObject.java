package io.github.vshnv.form.serialization;

import io.github.vshnv.form.annotation.PrimaryKey;

public class TestObject {
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
