package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        List<String> listStr = Arrays.asList("Саратов", "Москва", "Ялта", "Абаран", "Волгоград", "Петропавловск-Камчатский");

        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        listStr.sort(cmpText);
        System.out.print("В алфавитном порядке:  ");
        System.out.println(listStr);

        Comparator<String> cmpSize = (left, right) -> Integer.compare(left.length(), right.length());
        listStr.sort(cmpSize);
        System.out.print("По возрастанию длины:   ");
        System.out.println(listStr);

        Comparator<String> cmpDecSize = (left, right) -> Integer.compare(right.length(), left.length());
        listStr.sort(cmpDecSize);
        System.out.print("По убыванию длины:   ");
        System.out.println(listStr);
    }
}
