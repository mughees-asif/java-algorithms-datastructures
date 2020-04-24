package com.mughees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        // Deque [Deck] (double-ended queue), supports insertion & removal at both ends
        // resizable array class
        ArrayDeque<Employee> queue = new ArrayDeque<>(10);
        queue.add(johnDoe);
        queue.add(johnDoe);
        System.out.println(queue);

        // no resizing of the array
        ArrayBlockingQueue<Employee> queue1 = new ArrayBlockingQueue<>(1);
        queue1.add(janeJones);
//        queue.add(marySmith);
        System.out.println(queue);

        // LinkedList queue
        ConcurrentLinkedQueue<Employee> queue2 = new ConcurrentLinkedQueue<>();
        queue2.add(janeJones);
        System.out.println(queue1);
    }
}
