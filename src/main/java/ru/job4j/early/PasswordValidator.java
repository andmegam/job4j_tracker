package ru.job4j.early;

import java.util.HashSet;

import static java.util.Arrays.asList;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Пароль не может быть пустым.");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Длина пароля должна находиться в диапазоне [8, 32].");
        }
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean specialChar = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                upper = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                lower = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                digit = true;
            }
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                specialChar = true;
            }
        }
        if (!upper) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ в верхнем регистре.");
        }
        if (!lower) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ в нижнем регистре.");
        }
        if (!digit) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одину цифру.");
        }
        if (!specialChar) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один спецсимвол.");
        }

        HashSet<String> invalidPassword = new HashSet<>(asList("qwerty", "12345", "password", "admin", "user"));
        for (String s : invalidPassword) {
            if (password.toLowerCase().contains(s)) {
                throw new IllegalArgumentException("В составе пароля содержатся недопустимые подстроки.");
            }
        }
        return "Valid password.";
    }
}
