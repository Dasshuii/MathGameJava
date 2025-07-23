package org.dashui;

public class Main {
    public static void main(String[] args) {
        GameModeMenu gameModeMenu = new GameModeMenu();
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        Game game = new Game();
        boolean exit = false;
        do {
            String name = welcome();
            gameModeMenu.show();
            int opt = Integer.parseInt(Input.getUserInput("opt: "));

            if (opt == 0) exit = true;

            difficultyMenu.show();
            int difficultyOpt = Integer.parseInt(Input.getUserInput("opt: "));
            int score = game.start(GameMode.fromInt(opt), Difficulty.fromInt(difficultyOpt));
            System.out.printf("Your score was %d\n", score);
            exit = true;
        } while(!exit);
    }

    private static String welcome() {
        System.out.println("Welcome to Math Game!");
        String name = Input.getName("What's your name: ");
        System.out.printf("Hello %s!\n", name);
        return name;
    }
}