package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenCalcMinus1ThenException() {
        new Fact().calc(-1);
    }

    @Test
    public void whenCalc2Then2() {
        int fact = new Fact().calc(2);
        Assert.assertEquals(fact, 2);
    }
}