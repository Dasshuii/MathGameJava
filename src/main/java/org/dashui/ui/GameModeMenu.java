package org.dashui.ui;

import org.dashui.models.enums.GameMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GameModeMenu extends Menu {
    @Override
    public void configure() {
        startIndex = 0;
        options = new ArrayList<>();
        options.add("Exit");

        options.addAll(
                Arrays.stream(GameMode.values())
                        .map(Enum::name)
                        .collect(Collectors.toList())
        );

        options.add("View Game History");
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
