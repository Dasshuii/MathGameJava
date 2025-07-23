package org.dashui;

public class GameRecord {
    private String name = null;
    private int score = 0;
    private String gameMode;
    private int timeInSeconds;

    GameRecord(String name, int score, String gameMode, int timeInSeconds) {
        this.name = name;
        this.score = score;
        this.gameMode = gameMode;
        this.timeInSeconds = timeInSeconds;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %d", name, score, gameMode, timeInSeconds);
    }
}
