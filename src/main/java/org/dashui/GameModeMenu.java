package org.dashui;

public class GameModeMenu extends Menu{
    protected String[] options = new String[]{"Addition", "Subtraction", "Multiplication", "Division", "Random"};

    @Override
    public void show() {
        for (int i = 0; i < options.length; i++) {
            System.out.printf("[%d] %s\n", i + 1, options[i]);
        }
        System.out.printf("[%d] View Game History\n", options.length);
        System.out.println("[0] Exit");
    }
}
