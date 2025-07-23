package org.dashui;

public class DifficultyMenu extends Menu {
    private String[] options = new String[]{"EASY", "MEDIUM", "HARD"};

    @Override
    public void show() {
        for (int i = 0; i < options.length; i++) {
            System.out.printf("[%d] %s\n", i, options[i]);
        }
    }
}
