package ru.job4j.map;

import java.util.List;
import java.util.Objects;

public class Pupil {
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pupil pupil = (Pupil) o;
        return Objects.equals(name, pupil.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}