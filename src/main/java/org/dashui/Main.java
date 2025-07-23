package org.dashui;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int ATTEMPTS = 5;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Math Game!");
        System.out.print("What's your name: ");
        String name = scanner.nextLine();

        System.out.printf("Hello %s!", name);
        System.out.println("=== GAME MENU ===");
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division");
        System.out.println("[5] Random");
        System.out.println("[6] View Game History");
        System.out.println("[0] Exit");
        int opt = Integer.valueOf(scanner.nextLine());

        switch (opt) {
            default:
                System.out.println("[0] EASY");
                System.out.println("[1] MEDIUM");
                System.out.println("[2] HARD");

                int difficultyOpt = Integer.valueOf(scanner.nextLine());

                int score = start(GameMode.fromInt(opt), Difficulty.fromInt(difficultyOpt));
                System.out.printf("Your score was %d", score);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public static int start(GameMode gameMode, Difficulty difficulty) {
        int score = 0;

        for (int i = 0; i < ATTEMPTS; i++) {
            int num1 = random.nextInt(0, 11);
            int num2 = random.nextInt(1, 11);
            char operation = getOperation(gameMode);

            String question = String.format("%s %s %s = ?", num1, operation, num2);
            System.out.println(question);

            int answer = Integer.valueOf(scanner.nextLine());

            if (answer == calculateResult(operation, num1, num2)) {
                System.out.println("Correct!");
                score++;
            } else
                System.out.println("Incorrect :(");
        }

        System.out.println("Thanks for playing!");
        return score;
    }

    private static int calculateResult(char operation, int num1, int num2) {
        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }

    private static char getOperation(GameMode gameMode) {
        return switch (gameMode) {
            case ADDITION -> '+';
            case SUBTRACTION -> '-';
            case MULTIPLICATION -> '*';
            case DIVISION -> '/';
            case RANDOM -> "+-*/".toCharArray()[random.nextInt(4)];
        };
    }
}