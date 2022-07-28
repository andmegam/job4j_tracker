package ru.job4j.map;

import java.util.Objects;

public class Label implements Comparable<Label> {
    private String name;
    private double score;

    public Label(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Label label = (Label) o;
        return Objects.equals(name, label.name) && Double.compare(label.score, score) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public int compareTo(Label o) {
        return Double.compare(this.score, o.score);
    }

    @Override
    public String toString() {
        return "Label{"
                + "name='" + name + '\''
                + ", score=" + score
                + '}';
    }
}
