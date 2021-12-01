package ru.job4j.inheritance;

import java.util.Date;

public class Surgeon extends Doctor {

    private int countOperation;

    public Surgeon(String name, String surname, String education, Date birthday, String speciality, int countOperation) {
        super(name, surname, education, birthday, speciality);
        this.countOperation = countOperation;
    }

    public Patient makeSurgery(Patient patient) {
        return new Patient("Вася");
    }
}
