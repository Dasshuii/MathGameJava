package org.dashui;

import org.dashui.models.GameRecord;
import org.dashui.models.enums.Difficulty;
import org.dashui.models.enums.GameMode;
import org.dashui.util.Input;

import java.util.Random;

public class Game {
    private final int ATTEMPTS = 5;
    private final QuestionGenerator generator = new QuestionGenerator();

    public GameRecord start(String playerName, GameMode gameMode, Difficulty difficulty) {
        int score = 0;

        long start = System.currentTimeMillis();
        for (int i = 0; i < ATTEMPTS; i++) {
            Question question = generator.generate(gameMode, difficulty);
            System.out.println(question.questionText());
            int answer = Input.getInt("Answer:");
            if (answer == question.correctAnswer()) {
                System.out.println("Correct!");
                score++;
            } else
                System.out.println("Incorrect :(");
        }
        long finish = System.currentTimeMillis();

        return new GameRecord(
                playerName,
                score,
                gameMode,
                difficulty,
                (int) ((finish - start) / 1000)
        );
    }
}
