package com.mughees;

import javax.xml.transform.Templates;
import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtable() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put (String key, Employee employee) {
        int hashkey = hashKey(key);
        hashtable[hashkey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashkey = hashKey(key);
        ListIterator<StoredEmployee> iter = hashtable[hashkey].listIterator();
        StoredEmployee employee = null;
        while (iter.hasNext()) {
            employee = iter.next();
            if (employee.key.equals(key)) {
                return employee.employee;
            }
        }
        return null;
    }

    public Employee remove(String key) {
        int hashkey = hashKey(key);
        ListIterator<StoredEmployee> iter = hashtable[hashkey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while (iter.hasNext()) {
            employee = iter.next();
            index++;
            if (employee.key.equals(key)) {
                break;
            }
        }
        if (employee == null || !employee.key.equals(key)) {
            return null;
        } else {
            hashtable[hashkey].remove(index);
            return employee.employee;
        }
    }

    private int hashKey(String key) {
//        return key.length() % hashtable.length;

        // ensure valid index values
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("Position " + i + ": empty");
            } else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredEmployee> iter = hashtable[i].listIterator();
                while (iter.hasNext()) {
                    System.out.print(iter.next().employee);
                    System.out.print(" -> ");
                }
                System.out.print(" null ");
            }
        }
    }
}
