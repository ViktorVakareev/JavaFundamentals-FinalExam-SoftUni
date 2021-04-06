package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;

public class ActivationKeys01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder keySB = new StringBuilder(key);

        while (!input.equals("Generate")) {
            String[] commandsArray = input.split(">>>");
            String command = commandsArray[0];
            switch (command) {
                case "Contains":
                    String subString = commandsArray[1];
                    if (keySB.toString().contains(subString)) {
                        System.out.printf("%s contains %s%n", keySB.toString(), subString);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    String upperOrLower = commandsArray[1];
                    int fromIndex = Integer.parseInt(commandsArray[2]);
                    int toIndex = Integer.parseInt(commandsArray[3]);
                    String subStr = keySB.substring(fromIndex, toIndex);

                    if (upperOrLower.equals("Upper")) {
                        keySB.replace(fromIndex, toIndex, subStr.toUpperCase());
                    } else {
                        keySB.replace(fromIndex, toIndex, subStr.toLowerCase());
                    }
                    System.out.println(keySB.toString());
                    break;

                case "Slice":
                    int startIndex = Integer.parseInt(commandsArray[1]);
                    int endIndex = Integer.parseInt(commandsArray[2]);
                    keySB.replace(startIndex, endIndex, "");
                    System.out.println(keySB.toString());
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", keySB.toString());
    }
}
