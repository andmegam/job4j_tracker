package ru.job4j.inheritance;

import java.util.Date;

public class Builder extends Engineer {
    private String license;

    public Builder(String name, String surname, String education, Date birthday, int seniority, String license) {
        super(name, surname, education, birthday, seniority);
        this.license = license;
    }

    public Home build() {
        return new Home();
    }
}
