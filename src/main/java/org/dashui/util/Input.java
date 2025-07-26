package org.dashui.util;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().strip();
    }

    public static int getInt(String prompt) {
        int input;
        while(true) {
            try {
                String line = getNonEmptyString(prompt);
                input = Integer.parseInt(line);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static int getInt(String prompt, int min, int max) {
        int input;
        while(true) {
            try {
                String line = getNonEmptyString(prompt);

                input = Integer.parseInt(line);

                if (input < min || input > max) {
                    System.out.printf("Please enter a number between %d and %d.\n", min, max);
                } else
                    return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static String getNonEmptyString(String prompt) {
        while (true) {
            String input = getString(prompt);

            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty.");
        }
    }
}
