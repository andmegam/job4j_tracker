package ru.job4j.stream;

import java.time.LocalDate;

public class Car {
    private String brand;
    private String model;
    private LocalDate created;
    private double volume;
    private String color;

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.created = created;
            car.volume = volume;
            car.color = color;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("ВАЗ")
                .buildModel("2101")
                .buildCreated(LocalDate.of(1976, 6, 1))
                .buildVolume(1.4)
                .buildColor("Красный")
                .build();
        System.out.println(car);

        Car car2 = new Builder()
                .buildBrand("Волга")
                .buildModel("Сайбер")
                .buildColor("Белый")
                .buildCreated(LocalDate.of(2001, 1, 12))
                .build();
        System.out.println(car2);

        Car car3 = new Builder()
                .buildBrand("УАЗ")
                .buildColor("Серый")
                .buildCreated(LocalDate.of(2010, 1, 3))
                .build();
        System.out.println(car3);
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", created=" + created
                + ", volume=" + volume
                + ", color='" + color + '\''
                + '}';
    }
}