package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void validateWhenValid() {
        String password = "@ABCDEFGH7q";
        String expected = "Valid password.";
        String actual = PasswordValidator.validate(password);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void validateWhenNull() {
        assertThatThrownBy(() -> {
            PasswordValidator.validate(null);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Пароль не может быть пустым.");
    }

    @Test
    void validateWhenInvalidLength() {
        assertThatThrownBy(() -> {
            PasswordValidator.validate("@ABCDE");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Длина пароля должна находиться в диапазоне [8, 32].");
    }

    @Test
    public void validateWhenInvalidFlagUpper() {
        assertThatThrownBy(() -> {
            PasswordValidator.validate("@abcdefgh7q");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Пароль должен содержать хотя бы один символ в верхнем регистре.");
    }

    @Test
    public void validateWhenInvalidFlagLower() {
        assertThatThrownBy(() -> {
            PasswordValidator.validate("@ABCDEFGH7Q");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Пароль должен содержать хотя бы один символ в нижнем регистре.");
    }

    @Test
    public void validateWhenInvalidFlagDigit() {
        assertThatThrownBy(() -> {
            PasswordValidator.validate("@ABCDEFGHq");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Пароль должен содержать хотя бы одину цифру.");
    }

    @Test
    public void validateWhenInvalidFlagSpecialChar() {
        assertThatThrownBy(() -> {
            PasswordValidator.validate("ABCDEFGH7q");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Пароль должен содержать хотя бы один спецсимвол.");
    }

    @Test
    public void validateWhenInvalidSubStr() {
        assertThatThrownBy(() -> {
            PasswordValidator.validate("@Qwerty123");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("В составе пароля содержатся недопустимые подстроки.");
    }
}