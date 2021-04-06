package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;

public class SecretChat111 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] commandArray = input.split(":\\|:");
            String command = commandArray[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandArray[1]);
                    sb.insert(index, " ");
                    System.out.println(sb.toString());
                    break;
                case "Reverse":
                    String text = commandArray[1];
                    if (sb.toString().contains(text)) {
                        int index2 = sb.indexOf(text);
                        sb = sb.replace(index2, index2 + text.length(), "");
                        StringBuilder reversedText = new StringBuilder(text);
                        reversedText = reversedText.reverse();
                        sb.append(reversedText);
                        System.out.println(sb.toString());
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substring = commandArray[1];
                    String replacement = commandArray[2];
                    String replaced=sb.toString().replace(substring,replacement);
                    sb=new StringBuilder(replaced);
                    System.out.println(sb.toString());
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", sb.toString());
    }
}
