package ru.job4j.inheritance;

import java.util.Date;

public class Programmer extends Engineer {

    private String programmingLanguage;

    public Programmer(String name, String surname, String education, Date birthday, int seniority, String programmingLanguage) {
        super(name, surname, education, birthday, seniority);
        this.programmingLanguage = programmingLanguage;
    }

    public Program makeProgram() {
        return new Program();
    }
}
