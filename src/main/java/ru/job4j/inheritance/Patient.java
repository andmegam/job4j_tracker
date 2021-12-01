package ru.job4j.inheritance;

public class Patient {

    private String surname;
    private Diagnosis diagnosis;

    public String getSurname() {
        return surname;
    }

    public Patient(String surname) {
        this.surname = surname;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
}
