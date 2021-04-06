package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;

public class ImitationGame01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String eMessage = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(eMessage);

        while (!input.equals("Decode")) {
            String[] commandArray = input.split("\\|");
            String command = commandArray[0];

            switch (command) {
                case "Move":
                    int number = Integer.parseInt(commandArray[1]);
                    String move = sb.substring(0, number);
                    sb.insert(sb.length(), move);
                    sb.replace(0, number, "");
//                    String concat =sb.toString().concat(move);
//                    sb=new StringBuilder(concat);

                    break;
                case "Insert":
                    int index = Integer.parseInt(commandArray[1]);
                    String value = commandArray[2];
                    sb.insert(index, value);

                    break;
                case "ChangeAll":
                    String subString = commandArray[1];
                    String replace = commandArray[2];

                    String replaced = sb.toString().replaceAll(subString, replace);
                    sb = new StringBuilder(replaced);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", sb.toString());
    }
}
