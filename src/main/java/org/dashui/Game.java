package org.dashui;

import org.dashui.models.GameRecord;
import org.dashui.models.enums.Difficulty;
import org.dashui.models.enums.GameMode;
import org.dashui.util.Input;

import java.util.Random;

public class Game {
    private final int ATTEMPTS = 5;
    private final Random random = new Random();

    public GameRecord start(GameMode gameMode, Difficulty difficulty) {
        int score = 0;
        int[] minMax = getMinMax(difficulty);

        long start = System.currentTimeMillis();
        for (int i = 0; i < ATTEMPTS; i++) {
            char operation = getOperation(gameMode);
            int num1 = getRandomNumber(minMax[0], minMax[1]);
            int num2 = operation == '/' ?
                    getDivisor(num1, minMax[0], minMax[1]) : getRandomNumber(minMax[0], minMax[1]);


            String question = String.format("%s %s %s = ?", num1, operation, num2);
            System.out.println(question);

            int answer = Integer.parseInt(Input.getUserInput("Answer: "));

            if (answer == calculateResult(operation, num1, num2)) {
                System.out.println("Correct!");
                score++;
            } else
                System.out.println("Incorrect :(");
        }
        long finish = System.currentTimeMillis();

        System.out.println("Thanks for playing!");
        GameRecord gameRecord = new GameRecord();
        gameRecord.setTimeInSeconds((int)(finish - start) / 1000);
        gameRecord.setScore(score);
        return gameRecord;
    }

    private int calculateResult(char operation, int num1, int num2) {
        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
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

    private int getRandomNumber(int min, int max) {
        return random.nextInt(min, max);
    }

    private int[] getMinMax(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> new int[]{0, 10};
            case MEDIUM -> new int[]{10, 50};
            case HARD -> new int[]{50, 100};
        };
    }

    private int getDivisor(int num1, int min, int max) {
        int num2 = getRandomNumber(min, max);
        while(num2 == 0 || num1 % num2 != 0) {
            num2 = getRandomNumber(min, max);
        }
        return num2;
    }

}
