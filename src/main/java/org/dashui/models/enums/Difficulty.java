package org.dashui.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum Difficulty {
    EASY(0),
    MEDIUM(1),
    HARD(2);

    private final int value;
    private static final Map<Integer, Difficulty> difficultyMap = new HashMap<>();

    static {
        for (Difficulty difficulty : values()) {
            difficultyMap.put(difficulty.value, difficulty);
        }
    }

    Difficulty(int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }

    public static final Difficulty fromInt(int value) {
        return difficultyMap.get(value);
    }
}
