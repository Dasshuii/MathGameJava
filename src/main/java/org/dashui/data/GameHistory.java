package org.dashui.data;

import org.dashui.models.GameRecord;

import java.util.ArrayList;

public class GameHistory {
    private ArrayList<GameRecord> records = new ArrayList<>();

    public void addRecord(GameRecord gameRecord) {
        records.add(gameRecord);
    }

    public void showGameHistory() {
        if (records.isEmpty()) {
            System.out.println("No games played yet.");
            return;
        }
        System.out.println("NAME - SCORE - MODE - DIFFICULTY - SECONDS");
        for (var record : records) {
            System.out.println(record.toString());
        }
    }
}
