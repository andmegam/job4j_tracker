package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс описывает стандартизированную структуру организации в виде подчиненных подразделений департамент/служба/отдел.
 *
 * @author Mashkov Andrey
 * @version 1.0
 */
public class Departments {
    /**
     * Дополняет список недостающими подразделениями.
     *
     * @param deps - список подразделений организации.
     * @return упорядоченный список подразделений организации.
     */
    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        for (String dep : deps) {
            String start = "";
            for (String el : dep.split("/")) {
                start = "".equals(start) ? el : start + "/" + el;
                rsl.add(start);
            }
        }
        return new ArrayList<>(rsl);
    }

    /**
     * Сортировка подразделений организации в естественном порядке.
     *
     * @param orgs - список подразделений организации для сортировки;
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Сортировка подразделений организации в порядке, объявленном в классе DepDescComp.
     *
     * @param orgs - список подразделений организации;
     */
    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}