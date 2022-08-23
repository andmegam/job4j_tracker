package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс для сортировки подразделений организации в обратном порядке.
 *
 * @author Mashkov Andrey
 * @version 1.0
 */
public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int compare = second[0].compareTo(first[0]);
        return compare == 0 ? o1.compareTo(o2) : compare;
    }
}
