package org.dashui.ui;

public class GameModeMenu extends Menu {
    private String[] options = new String[]{"Addition", "Subtraction", "Multiplication", "Division", "Random"};

    @Override
    public void show() {
        for (int i = 0; i < options.length; i++) {
            System.out.printf("[%d] %s\n", i + 1, options[i]);
        }
        System.out.printf("[%d] View Game History\n", options.length + 1);
        System.out.println("[0] Exit");
    }
}
