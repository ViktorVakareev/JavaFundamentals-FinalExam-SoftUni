package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;

public class SecretChat01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder sb = new StringBuilder(message);
        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] commandArray = input.split(":\\|:");
            String command = commandArray[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandArray[1]);
                    sb = sb.insert(index, " ");
                    System.out.println(sb.toString());
                    break;
                case "Reverse":
                    String text = commandArray[1];
                    if (sb.toString().contains(text)) {
                        StringBuilder cutSB = new StringBuilder(text);
                        cutSB=cutSB.reverse();
                        int indexText=sb.indexOf(text);
                        sb.delete(indexText,indexText+text.length());
                        text= cutSB.toString();
                        sb.append(text);
                        System.out.println(sb.toString());
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String subString = commandArray[1];
                    String replacement = commandArray[2];
                    sb = new StringBuilder(sb.toString().replaceAll(subString, replacement));
                    System.out.println(sb.toString());
                    break;

            }

            input = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", sb.toString());
    }
}
