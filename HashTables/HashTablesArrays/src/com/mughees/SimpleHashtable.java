package com.mughees;

public class SimpleHashtable {
    private Employee[] hashtable;

    public SimpleHashtable() {
        hashtable = new Employee[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }
}
