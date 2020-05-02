package com.mughees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        Map<String, Employee> hashMap = new HashMap<>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);
        // Employee employee = hashMap.put("Doe", mikeWilson);

        // only insert value if key absent
        Employee employee = hashMap.putIfAbsent("Doe", mikeWilson);
        System.out.println(employee);
        System.out.println("===========================");

        // get method
        System.out.println(hashMap.get("Smith"));
        System.out.println("===========================");

        // remove method
        System.out.println(hashMap.remove("Jones"));
        System.out.println("===========================");

        // check if map contains key
        System.out.println(hashMap.containsKey("Doe"));
        System.out.println(hashMap.containsValue(janeJones));

        // printing hashMap
        System.out.println("============== Method 1 =============");
        Iterator<Employee> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("============== Method 2 (JDK 8 or above) =============");
        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));
    }
}
