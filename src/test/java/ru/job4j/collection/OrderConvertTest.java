package ru.job4j.collection;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderConvertTest {

    @Test
    void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertEquals(map.get("3sfe"), new Order("3sfe", "Dress"));
    }

    @Test
    void whenProcess() {
        List<Order> list = new ArrayList<>(Arrays.asList(
                new Order("1", "Молоко"),
                new Order("2", "Хлеб"),
                new Order("3", "Мясо")
        ));

        Map<String, Order> expected = new HashMap<>();
        expected.put("1", new Order("1", "Молоко"));
        expected.put("2", new Order("2", "Хлеб"));
        expected.put("3", new Order("3", "Мясо"));
        assertThat(OrderConvert.process(list)).containsExactlyEntriesOf(expected);
    }

    @Test
    void whenIncludeDuplicate() {
        List<Order> list = new ArrayList<>(Arrays.asList(
                new Order("1", "Молоко"),
                new Order("2", "Хлеб"),
                new Order("3", "Мясо"),
                new Order("1", "Молоко")
        ));

        Map<String, Order> expected = new HashMap<>();
        expected.put("1", new Order("1", "Молоко"));
        expected.put("2", new Order("2", "Хлеб"));
        expected.put("3", new Order("3", "Мясо"));
        assertThat(OrderConvert.process(list)).containsExactlyEntriesOf(expected);
    }

}