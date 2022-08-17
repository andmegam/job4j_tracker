package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс BankService реализует систему управления данными о пользователях банка и их счетах.
 *
 * @author Mashkov Andrey
 * @version 1.0
 */
public class BankService {
    /**
     * Данные о пользователях и их счетах.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя при условии, что данного пользователя в системе еще нет.
     *
     * @param user пользователь, которого необходимо добавить.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Возвращает пользователя по данным паспорта.
     *
     * @param passport паспорт пользователя.
     * @return возвращает пользователя, если он найден или null.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Добавляет пользователю банковский аккаунт, при условии, что этого аккаунта у пользователя еще нет.
     *
     * @param passport   паспорт пользователя.
     * @param newAccount счет в банке, который необходимо добавить пользователю.
     */
    public void addAccount(String passport, Account newAccount) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(newAccount)) {
                list.add(newAccount);
            }
        }
    }

    /**
     * Возвращает банковский аккаунт пользователя.
     *
     * @param passport  паспорта пользователя.
     * @param requisite реквизиты счета.
     * @return возвращает банковский аккаунт пользователя, если он найден или null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account findAccount = null;
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    findAccount = account;
                    break;
                }
            }
        }
        return findAccount;
    }

    /**
     * Переводит денежные средства с одного счета на другой.
     *
     * @param srcPassport   пользователь, со счета которого нужно списать денежные средства.
     * @param srcRequisite  счет, с которого нужно списать денежные средства.
     * @param destPassport  пользователь, на счет которого нужно перевести денежные.
     * @param destRequisite счет, на который нужно перевести денежные средства.
     * @param amount        сумма перевода
     * @return возвращает true случае успеха перевода, false в обратном случае
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }
}
