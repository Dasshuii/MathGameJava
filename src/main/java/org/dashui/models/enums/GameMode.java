package org.dashui.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum GameMode {
    ADDITION(1),
    SUBTRACTION(2),
    MULTIPLICATION(3),
    DIVISION(4),
    RANDOM(5);

    private final int value;
    private static final Map<Integer, GameMode> gameModeMap = new HashMap<>();

    static {
        for (GameMode gameMode : values()) {
            gameModeMap.put(gameMode.value, gameMode);
        }
    }

    GameMode(int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }

    public static final GameMode fromInt(int value) {
        return gameModeMap.get(value);
    }
}
