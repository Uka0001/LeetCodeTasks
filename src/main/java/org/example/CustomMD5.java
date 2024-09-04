package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class CustomMD5 {

    private static String customMD5(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(message.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = "";

        System.out.print("Please enter your password: ");
        String userInput = scanner.nextLine();
        String userPasswordMD5 = customMD5(userInput);

        try {
            File file = new File("/Users/oleksii/projects/Leetcode/Leetcode/src/main/resources/password.txt");
            if (file.exists() && file.length() > 0) {
                Scanner fileScanner = new Scanner(file);
                firstLine = fileScanner.nextLine();
                fileScanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (firstLine.equals(userPasswordMD5)) {
            System.out.println("Success! Your password hash: " + userPasswordMD5);
            passUpdate();
        } else {
            errorMessage();
        }

        scanner.close();
    }

    private static void passUpdate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to update your password? ");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("yes")) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            String hashedNewPassword = customMD5(newPassword);

            try {
                FileWriter writer = new FileWriter("/Users/oleksii/projects/Leetcode/Leetcode/src/main/resources/password.txt");
                writer.write(hashedNewPassword);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Password updated. Hash of the new password: " + hashedNewPassword);
            scanner.close();
            redirectWeb();
        } else {
            scanner.close();
            redirectWeb();
        }
    }

    private static void redirectWeb() {
        try {
            Desktop.getDesktop().browse(new URI("http://nure.ua"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void errorMessage() {
        System.out.println("Error: Incorrect password entered. Exiting the application.");
    }
}
