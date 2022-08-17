package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель данных User, содержит информацию о пользователе банка.
 *
 * @author Mashkov Andrey
 * @version 1.0
 */
public class User {
    /**
     * Паспортные данные пользователя.
     */
    private String passport;
    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Конструктор класса User.
     *
     * @param passport паспортные данные нового пользователя.
     * @param username имя нового пользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Сравнение объектов типа User происходит по значению поля passport.
     *
     * @param o сравниваемый объект
     * @return возвращает true при равенстве объектов и false при неравенстве.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    /**
     * Возвращает паспортные данные пользователя.
     *
     * @return возвращает значение переменной passport.
     */
    public String getPassport() {
        return passport;
    }
}
