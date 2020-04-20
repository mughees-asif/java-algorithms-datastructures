package com.mughees;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();
        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println("Is the list empty: " + list.isEmpty() + "\n");

        System.out.println("The size of the list is: " + list.getSize() + "\n");

        list.printList();

        list.removeFromFront();
        System.out.println("The size of the list after removing head node: " + list.getSize() + "\n");
        list.printList();
    }
}
