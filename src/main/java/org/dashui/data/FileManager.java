package org.dashui.data;

import org.dashui.Game;
import org.dashui.models.GameRecord;
import org.dashui.models.enums.Difficulty;
import org.dashui.models.enums.GameMode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String path = "C:\\Users\\naomy\\IdeaProjects\\MathGameJava\\src\\records.csv";

    public static void saveRecords(List<GameRecord> gameRecords) {
        try (FileWriter myWriter = new FileWriter(path)) {;
            for (var record : gameRecords)
                myWriter.write(record.toCSV() + '\n');
        } catch (IOException e) {
            System.out.println("Failed to save records.");
            e.printStackTrace();
        }
    }

    public static List<GameRecord> loadRecords() {
        List<GameRecord> gameRecords = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()) return gameRecords;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                GameRecord gameRecord = GameRecord.fromCSV(record);
                if (record != null) gameRecords.add(gameRecord);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void initFile() {
        File file = new File(path);

        if (!file.exists() && !file.isDirectory()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred");
                e.printStackTrace();
            }
        }
    }
}
