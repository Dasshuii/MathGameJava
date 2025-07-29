package org.dashui.models;

import org.dashui.models.enums.Difficulty;
import org.dashui.models.enums.GameMode;

public final class GameRecord {
    private String name;
    private int score;
    private GameMode gameMode;
    private Difficulty difficulty;
    private int timeInSeconds;

    public GameRecord() {}

    public GameRecord(String name, int score, GameMode gameMode, Difficulty difficulty, int timeInSeconds) {
        this.name = name;
        this.score = score;
        this.gameMode = gameMode;
        this.difficulty = difficulty;
        this.timeInSeconds = timeInSeconds;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s, %d", name, score, gameMode.name(), difficulty.name(), timeInSeconds);
    }

    public String toCSV() {
        return String.format("%s,%d,%s,%s,%d", name, score, gameMode.name(), difficulty.name(), timeInSeconds);
    }

    public static GameRecord fromCSV(String[] record) {
        return new GameRecord(record[0], Integer.valueOf(record[1]), GameMode.valueOf(record[2]), Difficulty.valueOf(record[3]), Integer.valueOf(record[4]));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public final int getScore() {
        return score;
    }
}
