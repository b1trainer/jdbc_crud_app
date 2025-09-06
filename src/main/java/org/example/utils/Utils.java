package org.example.utils;

import java.util.Scanner;

public final class Utils {

    private static final Scanner scanner = new Scanner(System.in);

    private Utils() {
    }

    public static int getIntFromInput(String message) {
        System.out.println(message);

        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
