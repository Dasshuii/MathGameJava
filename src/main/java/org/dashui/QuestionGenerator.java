package org.dashui;

import org.dashui.models.enums.Difficulty;
import org.dashui.models.enums.GameMode;

import java.util.Random;

public class QuestionGenerator {
    private final Random random = new Random();

    public Question generate(GameMode mode, Difficulty difficulty) {
        int[] range = getMinMax(difficulty);
        int num1 = getRandom(range[0], range[1]);
        char operation = getOperation(mode);
        int num2 = operation == '/' ? getDivisor(num1, range[0], range[1]) : getRandom(range[0], range[1]);
        int result = calculate(operation, num1, num2);
        String text = String.format("%d %c %d = ?", num1, operation, num2);
        return new Question(text, result);
    }

    private int calculate(char operation, int num1, int num2) {
        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }

    private int[] getMinMax(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> new int[]{0, 10};
            case MEDIUM -> new int[]{10, 50};
            case HARD -> new int[]{50, 100};
        };
    }


    private char getOperation(GameMode gameMode) {
        return switch (gameMode) {
            case ADDITION -> '+';
            case SUBTRACTION -> '-';
            case MULTIPLICATION -> '*';
            case DIVISION -> '/';
            case RANDOM -> "+-*/".toCharArray()[random.nextInt(4)];
        };
    }

    private int getDivisor(int num1, int min, int max) {
        int num2 = getRandom(min, max);
        while(num2 == 0 || num1 % num2 != 0) {
            num2 = getRandom(min, max);
        }
        return num2;
    }

    private int getRandom(int min, int max) {
        return random.nextInt(min, max);
    }
}
