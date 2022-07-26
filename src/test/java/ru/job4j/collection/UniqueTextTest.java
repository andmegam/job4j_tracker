package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueTextTest {

    @Test
    void isEquals() {
        String originText = "На рыбалке поймал сома и судака";
        String duplicateText = "На рыбалке поймал судака и сома";
        assertTrue(UniqueText.isEquals(originText, duplicateText));
    }

    @Test
    void isNotEquals() {
        String originText = "На рыбалке поймал сома и судака";
        String duplicateText = "На рыбалке поймал судака и леща";
        assertFalse(UniqueText.isEquals(originText, duplicateText));
    }

}