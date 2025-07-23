package org.dashui;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int ATTEMPTS = 5;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Math Game!");
        String name = Input.getName("What's your name: ");

        System.out.printf("Hello %s!\n", name);
        System.out.println("=== GAME MENU ===");
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division");
        System.out.println("[5] Random");
        System.out.println("[6] View Game History");
        System.out.println("[0] Exit");
        int opt = Integer.parseInt(scanner.nextLine());

        if (opt == 0) {
            System.exit(0);
        }
        else {
            System.out.println("[0] EASY");
            System.out.println("[1] MEDIUM");
            System.out.println("[2] HARD");

            int difficultyOpt = Integer.parseInt(scanner.nextLine());

            int score = start(GameMode.fromInt(opt), Difficulty.fromInt(difficultyOpt));
            System.out.printf("Your score was %d", score);
        }
    }

    public static int start(GameMode gameMode, Difficulty difficulty) {
        int score = 0;
        int[] minMax = getMinMax(difficulty);

        for (int i = 0; i < ATTEMPTS; i++) {
            char operation = getOperation(gameMode);
            int num1 = getRandomNumber(minMax[0], minMax[1]);
            int num2 = operation == '/' ?
                    getDivisor(num1, minMax[0], minMax[1]) : getRandomNumber(minMax[0], minMax[1]);


            String question = String.format("%s %s %s = ?", num1, operation, num2);
            System.out.println(question);

            int answer = Integer.parseInt(scanner.nextLine());

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

    private static int getRandomNumber(int min, int max) {
        return random.nextInt(min, max);
    }

    private static int[] getMinMax(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> new int[]{0, 10};
            case MEDIUM -> new int[]{10, 50};
            case HARD -> new int[]{50, 100};
        };
    }

    private static int getDivisor(int num1, int min, int max) {
        int num2 = getRandomNumber(min, max);
        while(num2 == 0 || num1 % num2 != 0) {
            num2 = getRandomNumber(min, max);
        }
        return num2;
    }
}