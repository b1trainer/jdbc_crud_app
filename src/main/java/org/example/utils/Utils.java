package org.example.utils;

import java.util.Scanner;

public final class Utils {
    private Utils() {
    }

    public static int getIntFromInput(String message) {
        System.out.println(message);

        try {
            Scanner scanner = new Scanner(System.in);

            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
