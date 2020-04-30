package com.mughees;

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
        if (stopIndex == hashKey) {
            return -1;
        } else {
            return hashKey;
        }
    }

    public void printHashtable() {
        for (StoredEmployee employee : hashtable) {
            System.out.println(employee);
        }
    }
}
