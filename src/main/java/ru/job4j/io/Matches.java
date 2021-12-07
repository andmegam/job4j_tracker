package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    private static int count = 11;
    private static boolean turn = true;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
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
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
