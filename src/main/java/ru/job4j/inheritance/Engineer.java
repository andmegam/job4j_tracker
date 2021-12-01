package ru.job4j.inheritance;

import java.util.Date;

public class Engineer extends Profession {

    private int seniority;
    private String report;

    public Engineer(String name, String surname, String education, Date birthday, int seniority) {
        super(name, surname, education, birthday);
        this.seniority = seniority;
        this.report = "";
    }

    public void writeReport() {
        this.report = getReport() + "****";
    }

    public String getReport() {
        return report;
    }
}
