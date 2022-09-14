package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = p -> p.getName().contains(key);
        Predicate<Person> predSurname = p -> p.getSurname().contains(key);
        Predicate<Person> predPhone = p -> p.getPhone().contains(key);
        Predicate<Person> predAddress = p -> p.getAddress().contains(key);
        Predicate<Person> combine = predName
                .or(predSurname
                        .or(predPhone
                                .or(predAddress)));
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}