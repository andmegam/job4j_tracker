package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных Account - счет в банке.
 *
 * @author Mashkov Andrey
 * @version 1.0
 */
public class Account {

    /**
     * Уникальный номер счета в банке.
     */
    private String requisite;
    /**
     * Количество денежных средств на счете.
     */
    private double balance;

    /**
     * Конструктор класса Account.
     *
     * @param requisite реквизиты создаваемого счета.
     * @param balance   количество денежных средств, на создаваемом счету.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Сравнение объектов типа Account происходит по значению поля requisite.
     *
     * @param o сравниваемый объект.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

    /**
     * Возвращает счет
     *
     * @return возвращает переменную requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Возвращает количество денежных средств, находящихся на счету.
     *
     * @return возвращает переменную balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает значение баланса счета.
     *
     * @param balance баланс текущего счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}