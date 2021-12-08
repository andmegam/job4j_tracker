package ru.job4j.poly;

public class TransportMovement {
    public static void main(String[] args) {
        Vehicle air1 = new Airplane("Sukhoi Superjet 100");
        Vehicle air2 = new Airplane("МС-21");
        Vehicle eBus1 = new ElectricBus("КамАЗ-6282");
        Vehicle eBus2 = new ElectricBus("ЛиАЗ-6274");
        Vehicle train1 = new Train("Москва-Казань");
        Vehicle train2 = new Train("Саратов-Самара");
        Vehicle[] vehicles = {air1, air2, eBus1, eBus2, train1, train2};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
