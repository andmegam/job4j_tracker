package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void area1() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertEquals(rsl, 8, 0.001);
    }

    @Test
    public void area2() {
        Point a  = new Point(0, 0);
        Point b = new Point(0, 16);
        Point c = new Point(0, 17);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertEquals(rsl, -1, 0.001);
    }
}