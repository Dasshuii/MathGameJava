package org.dashui.ui;

import org.dashui.models.enums.Difficulty;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DifficultyMenu extends Menu {
    @Override
    public void configure() {
        startIndex = 0;
        options = Arrays.stream(Difficulty.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
