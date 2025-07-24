package org.dashui;

public class GameRecord {
    private String name;
    private int score;
    private String gameMode;
    private String difficulty;
    private int timeInSeconds;

    GameRecord() {
        this.name = null;
        this.score = 0;
        this.gameMode = null;
        this.difficulty = null;
        this.timeInSeconds = 0;
    }

    GameRecord(String name, int score, String gameMode, String difficulty, int timeInSeconds) {
        this.name = name;
        this.score = score;
        this.gameMode = gameMode;
        this.difficulty = difficulty;
        this.timeInSeconds = timeInSeconds;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s, %d", name, score, gameMode, difficulty, timeInSeconds);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public final int getScore() {
        return score;
    }
}
