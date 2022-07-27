package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts)).containsExactlyElementsOf(expect);
    }

    @Test
    public void sentWhichTwoDuplicate() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Александр Пушкин", "123000"),
                new Account("456", "Иван Бунин", "456000"),
                new Account("789", "Афанасий Фет", "789000"),
                new Account("123", "Александр Пушкин", "123000"),
                new Account("789", "Афанасий Фет", "789000")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("789", "Афанасий Фет", "789000"),
                        new Account("456", "Иван Бунин", "456000"),
                        new Account("123", "Александр Пушкин", "123000")
                )
        );
        assertThat(NotifyAccount.sent(accounts)).containsExactlyElementsOf(expect);
    }
}