package org.dashui.data;

import org.dashui.models.GameRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameHistory {
    private final List<GameRecord> records;

    public GameHistory() {
        this.records = new ArrayList<>(FileManager.loadRecords());
    }

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

    public final List<GameRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }
}
