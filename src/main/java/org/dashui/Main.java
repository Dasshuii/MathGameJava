package org.dashui;

import org.dashui.data.FileManager;
import org.dashui.data.GameHistory;
import org.dashui.models.GameRecord;
import org.dashui.models.enums.Difficulty;
import org.dashui.models.enums.GameMode;
import org.dashui.ui.DifficultyMenu;
import org.dashui.ui.GameModeMenu;
import org.dashui.util.Input;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameModeMenu gameModeMenu = new GameModeMenu();
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        Game game = new Game();
        GameHistory history = new GameHistory();
        FileManager.initFile();

        String name = welcome();
        while(true) {
            gameModeMenu.show();
            int opt = Input.getInt("Option: ", 0, 7);

            if (opt == 0) break;

            if (opt == 6) {
                history.showGameHistory();
                continue;
            }

            GameMode gameMode = GameMode.fromInt(opt);
            if (gameMode == null) {
                System.out.println("Invalid game mode selected.");
                continue;
            }

            difficultyMenu.show();
            int difficultyOpt = Input.getInt("Difficulty: ", 0, 2);

            Difficulty difficulty = Difficulty.fromInt(difficultyOpt);
            if (difficulty == null) {
                System.out.println("Invalid difficulty selected.");
                continue;
            }

            GameRecord record = game.start(name, gameMode, difficulty);
            System.out.printf("Your score was %d\n", record.getScore());

            history.addRecord(record);
        }
        FileManager.saveRecords(history.getRecords());
    }

    private static String welcome() {
        System.out.println("Welcome to Math Game!");
        String name = Input.getNonEmptyString("What's your name: ");
        System.out.printf("Hello %s!\n", name);
        return name;
    }
}