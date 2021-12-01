package ru.job4j.inheritance;

import java.util.Date;

public class Dentist extends Doctor {

    private int seniority;

    public Dentist(String name, String surname, String education, Date birthday, String speciality, int seniority) {
        super(name, surname, education, birthday, speciality);
        this.seniority = seniority;
    }

    public Patient pullOutTooth(Patient patient) {
        return new Patient("Маша");
    }
}
