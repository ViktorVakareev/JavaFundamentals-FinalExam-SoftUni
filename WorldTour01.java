package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;

public class WorldTour01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder(text);

        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] commandArray = input.split(":");
            String command = commandArray[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(commandArray[1]);
                    String str = commandArray[2];
                    if (index >= 0 && index < sb.length()) {
                        sb.insert(index, str);

                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandArray[1]);
                    int endIndex = Integer.parseInt(commandArray[2]);

                    if (startIndex >= 0 && startIndex < sb.length() &&
                            endIndex >= 0 && endIndex < sb.length()) {
                        sb.replace(startIndex, endIndex+1,"");

                    }

                    break;
                case "Switch":
                    String oldString = commandArray[1];
                    String newString = commandArray[2];

                        String newStr = sb.toString().replaceAll
                                (oldString, newString);
                        sb = new StringBuilder(newStr);


                    break;
            }
            System.out.println(sb.toString());
            input = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", sb.toString());
    }
}
