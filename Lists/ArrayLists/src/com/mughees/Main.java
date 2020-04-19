package com.mughees;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        // print all items
        employeeList.forEach(System.out::println);
        System.out.println("=======================");

        // print specific entry
        System.out.println(employeeList.get(1));
        System.out.println("=======================");

        // check if list is empty
        System.out.println(employeeList.isEmpty());
        System.out.println("=======================");

        // replace items in the list
        employeeList.set(1, new Employee("John", "Adams", 15867));
        employeeList.forEach(System.out::println);
        System.out.println("=======================");

        // check the size of the list
        System.out.println(employeeList.size());
        System.out.println("=======================");

        // add to existing list
        employeeList.add(3, new Employee("Jone", "Doe", 586));
        employeeList.forEach(employee -> System.out.println(employee));
        System.out.println("=======================");

        // access the array which holds the items
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for (Employee employee : employeeArray)
            System.out.println(employee);
        System.out.println("=======================");
    }
}
