package org.dashui.data;

import org.dashui.models.GameRecord;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    private static final String path = "./records.txt";

    public static void saveRecords(List<GameRecord> gameRecords) {
        try {
            FileWriter myWriter = new FileWriter(path);

            for (var record : gameRecords)
                myWriter.write(record.toString() + '\n');
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

//    private static boolean fileExists() {
//        File file = new File(path);
//        return !file.exists() && !file.isDirectory();
//    }

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
