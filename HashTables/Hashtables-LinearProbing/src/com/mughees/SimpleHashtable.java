package com.mughees;

public class SimpleHashtable {

    private Employee[] hashtable;

    public SimpleHashtable() {
        hashtable = new Employee[10];
    }

    // simple hash table does not take into account collisions
    public void put(String key, Employee employee) {
        int hashKey = hashKey(key);
        if (hashtable[hashKey] != null) {
            System.out.println("An employee already exists at position: " + hashKey);
        } else {
            hashtable[hashKey] = employee;
        }
    }

    public Employee get(String key) {
        int hashKey = hashKey(key);
        return hashtable[hashKey];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void printHashtable() {
        for (Employee employee : hashtable) {
            System.out.println(employee);
        }
    }
}
