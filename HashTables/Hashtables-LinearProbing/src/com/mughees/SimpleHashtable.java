package com.mughees;

public class SimpleHashtable {

    private Employee[] hashtable;

    public SimpleHashtable() {
        hashtable = new Employee[10];
    }

    public void put(String key, Employee employee) {
        int hashKey = hashKey(key);
        if (occupied(hashKey)) {
            int stopIndex = hashKey;
            // creating the first value for the probe
            if (hashKey == hashtable.length - 1) {
                hashKey = 0;
            } else {
                hashKey++;
            }
            // each loop iteration the next probe position is set & includes wrapping
            while(occupied(hashKey) && hashKey != stopIndex) {
                hashKey = (hashKey + 1) % hashtable.length;
            }
        }
        if (occupied(hashKey)) {
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

    // check to see if space already occupied
    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (Employee employee : hashtable) {
            System.out.println(employee);
        }
    }
}
