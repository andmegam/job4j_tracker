package ru.job4j.stream.cards;

import java.util.stream.Stream;

public class DoubleLoopStream {
    public static void main(String[] args) {

        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}
