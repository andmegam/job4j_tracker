package ru.job4j.poly;

public class Airplane implements Vehicle {
    private String name;

    public Airplane(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("Самолет " + name + " летит на Юг.");
    }
}
