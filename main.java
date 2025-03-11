package com.example;

import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Worker> workers = List.of(
                new Worker("John", 160),
                new Worker("Michael", 200),
                new Worker("Andrew", 180),
                new Worker("David", 220),
                new Worker("Robert", 175)
        );

        List<Worker> topWorkers = workers.stream()
                .sorted(Comparator.comparingInt(Worker::getHoursWorked).reversed()) // Sort by hours worked in descending order
                .limit(3) // Select the top 3 workers
                .toList();

        topWorkers.forEach(System.out::println); // Print each worker
    }
}

class Worker {
    private String name;
    private int hoursWorked;

    public Worker(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return "Worker{name='" + name + "', hoursWorked=" + hoursWorked + "}";
    }
}
