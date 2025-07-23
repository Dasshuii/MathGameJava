package org.dashui;

public enum Difficulty {
    EASY(0),
    MEDIUM(1),
    HARD(2);

    private int value;

    Difficulty(int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }

    public static final Difficulty fromInt(int value) {
        for (Difficulty difficulty : Difficulty.values()) {
            if (difficulty.value == value) {
                return difficulty;
            }
        }
        return null;
    }
}
