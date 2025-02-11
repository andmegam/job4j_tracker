package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        int count = 11;
        boolean turn = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 0 && matches < 4) {
                turn = !turn;
                System.out.println(player + " ввел " + matches);
                count -= matches;
                System.out.println("Остаток: " + Math.max(0, count));
            } else {
                System.out.println("Введено некорректное значение пункта меню.");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
