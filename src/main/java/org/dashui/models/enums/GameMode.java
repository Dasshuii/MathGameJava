package org.dashui.models.enums;

public enum GameMode {
    ADDITION(1),
    SUBTRACTION(2),
    MULTIPLICATION(3),
    DIVISION(4),
    RANDOM(5);

    private int value;

    GameMode(int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }

    public static final GameMode fromInt(int value) {
        for (GameMode gameMode : GameMode.values()) {
            if (gameMode.value == value) {
                return gameMode;
            }
        }
        return null;
    }
}
