package ru.job4j.oop;


import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00to11then1dot41() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        double rsl = a.distance(b);
        double expected = 1.41;
        Assert.assertEquals(expected, rsl, 0.01);
    }
}