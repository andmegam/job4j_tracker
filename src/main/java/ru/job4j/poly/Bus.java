package ru.job4j.poly;

public class Bus implements Transport {

    private int petrolLiter;
    private int countPass;

    public Bus(int countPass, int petrolLiter) {
        this.countPass = countPass;
        this.petrolLiter = petrolLiter;
    }

    @Override
    public void drive() {
        System.out.println("В автобусе " + countPass + " пассажиров, "
                + "кол-во топлива: " + this.petrolLiter
                + "Сумма топлива: " + refuel(this.petrolLiter)
        );
    }

    @Override
    public void passengers(int countPass) {
        System.out.println("В рейс отправляется " + countPass + " пассажиров.");
    }

    @Override
    public double refuel(int petrolLiter) {
        double oilPrice = 49.55;
        return petrolLiter * oilPrice;
    }
}
