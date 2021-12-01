package ru.job4j.inheritance;

import java.util.Date;

public class Doctor extends Profession {

    private String speciality;

    public Doctor(String name, String surname, String education, Date birthday, String speciality) {
        super(name, surname, education, birthday);
        this.speciality = speciality;
    }

    public void toDiagnose(Patient patient) {
        patient.setDiagnosis(new Diagnosis("Определенный диагноз"));
    }

    public Diagnosis heal(Patient patient) {
        return patient.getDiagnosis();
    }
}
