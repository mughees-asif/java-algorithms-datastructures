package com.mughees;

import java.awt.*;

public class SimpleHashtable {

    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredEmployee[10];
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
            while (occupied(hashKey) && hashKey != stopIndex) {
                hashKey = (hashKey + 1) % hashtable.length;
            }
        }
        if (occupied(hashKey)) {
            System.out.println("An employee already exists at position: " + hashKey);
        } else {
            hashtable[hashKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hashKey = findKey(key);
        if(hashKey == -1) {
            return null;
        }
        return hashtable[hashKey].employee;
    }

    public Employee remove (String key) {
        int hashkey = findKey(key);
        if(hashkey == -1) {
            return null;
        }
        Employee employee = hashtable[hashkey].employee;

        // hashtable[hashkey] = null; --> bug: returns null

        // solution: rehashing
        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }
        return employee;
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    // check to see if space already occupied
    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    private int findKey(String key) {
        int hashKey = hashKey(key);
        if (hashtable[hashKey] != null &&
                hashtable[hashKey].key.equals(key)) {
            return hashKey;
        }
        int stopIndex = hashKey;
        if (hashKey == hashtable.length - 1) {
            hashKey = 0;
        } else {
            hashKey++;
        }
        while (hashKey != stopIndex && hashtable[hashKey] != null &&
                !hashtable[hashKey].key.equals(key)) {
            hashKey = (hashKey + 1) % hashtable.length;
        }
        // handles null pointer exceptions
        if (hashtable[hashKey] != null && hashtable[hashKey].key.equals(key))  {
            return hashKey;
        } else {
            return -1;
        }
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }
}
