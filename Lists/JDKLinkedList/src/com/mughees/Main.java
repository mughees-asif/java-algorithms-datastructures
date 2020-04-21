package com.mughees;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 87);

        LinkedList<Employee> list = new LinkedList<>();

        // addFirst = adds an item to the start of the list
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);
        printMethod(list);

        // add = adds an item to the end of list
        list.add(billEnd);
        printMethod(list);
    }

    // print the list
    public static void printMethod (LinkedList list) {
        Iterator iter = list.iterator();
        System.out.println("HEAD -> ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.println(" <=> ");
        }
        System.out.println("null");
        System.out.println("===========================");
    }
}
