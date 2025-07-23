package org.dashui;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().strip();
    }

    public static String getName(String prompt) {
        return getUserInput(prompt);
    }
}
