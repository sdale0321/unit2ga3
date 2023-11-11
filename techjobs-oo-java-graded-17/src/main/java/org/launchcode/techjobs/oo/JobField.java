package org.launchcode.techjobs.oo;

import java.util.Objects;

public class JobField {
    //TODO: Fields
    private int id;
    private static int nextId = 1;
    private String value;
    //TODO: Constructors

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //TODO: Custom Methods
    @Override
    public String toString() {
        return value;
    }

    //TODO: Getters / Setters


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }
}
