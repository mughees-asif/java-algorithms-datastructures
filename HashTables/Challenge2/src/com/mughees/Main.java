package com.mughees;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(System.out::println);

        HashMap<Integer, Employee> employeeHashMap = new HashMap<>();
        ListIterator<Employee> iter = employees.listIterator();
        List<Employee> remove = new ArrayList<>();

        while (iter.hasNext()) {
            Employee employee = iter.next();
            if (employeeHashMap.containsKey(employee.getId())) {
                remove.add(employee);
            } else {
                employeeHashMap.put(employee.getId(), employee);
            }
        }

        for (Employee employee : remove) {
            employees.remove(employee);
        }

        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        employees.forEach(System.out::println);
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }
}
