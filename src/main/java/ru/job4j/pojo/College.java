package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("A-141");
        student.setDateReceipt(LocalDate.of(2021, 9, 1));
        System.out.println("Студент " + student.getFullName() + " из группы " + student.getGroup() + " поступил " + student.getDateReceipt());
    }
}
