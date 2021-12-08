package ru.job4j.poly;

public class ElectricBus implements Vehicle {

    private final String name;

    public ElectricBus(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("Электробус " + name + " едет по асфальту.");
    }
}
