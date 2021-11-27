package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;

public class MaxTest {

    @Test
    public void whenA10B20ThenMax20() {
        int a = 10;
        int b = 20;
        int expected = 20;
        int rsl = Max.max(a, b);
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenA10B20C30ThenMax30() {
        int a = 10;
        int b = 20;
        int c = 30;
        int expected = 30;
        int rsl = Max.max(a, b, c);
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenA10B20C30D40ThenMax40() {
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        int expected = 40;
        int rsl = Max.max(a, b, c, d);
        Assert.assertEquals(expected, rsl);
    }

}