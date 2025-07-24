package org.dashui;

import org.dashui.data.GameHistory;
import org.dashui.models.GameRecord;
import org.dashui.models.enums.Difficulty;
import org.dashui.models.enums.GameMode;
import org.dashui.ui.DifficultyMenu;
import org.dashui.ui.GameModeMenu;
import org.dashui.util.Input;

public class Main {
    public static void main(String[] args) {
        GameModeMenu gameModeMenu = new GameModeMenu();
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        Game game = new Game();
        GameHistory history = new GameHistory();

        boolean exit = false;


        String name = welcome();
        do {
            gameModeMenu.show();
            int opt = Integer.parseInt(Input.getUserInput("opt: "));

            switch (opt) {
                case 0:
                    exit = true;
                    break;
                case 6:
                    history.showGameHistory();
                    break;
                default:
                    difficultyMenu.show();
                    int difficultyOpt = Integer.parseInt(Input.getUserInput("opt: "));
                    GameMode gameMode = GameMode.fromInt(opt);
                    Difficulty difficulty = Difficulty.fromInt(difficultyOpt);

                    GameRecord record = game.start(gameMode, difficulty);
                    System.out.printf("Your score was %d\n", record.getScore());
                    record.setName(name);
                    record.setGameMode(String.valueOf(gameMode));
                    record.setDifficulty(String.valueOf(difficulty));
                    history.addRecord(record);
                    break;
            }
        } while(!exit);

    }

    private static String welcome() {
        System.out.println("Welcome to Math Game!");
        String name = Input.getName("What's your name: ");
        System.out.printf("Hello %s!\n", name);
        return name;
    }
}