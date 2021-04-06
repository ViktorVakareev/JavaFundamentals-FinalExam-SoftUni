package com.softuni.fundamentals.FinalExam;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Final1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandArray = input.split(" ");
            String command = commandArray[0];

            switch (command) {
                case "Translate":
                    String letter = commandArray[1];
                    String replacementLetter = commandArray[2];
                    sb = new StringBuilder(sb.toString().replace(letter, replacementLetter));

                    System.out.println(sb.toString());
                    break;
                case "Includes":
                    String stringInclude = commandArray[1];
                    boolean include = false;
                    if (sb.toString().contains(stringInclude)) {
                        include = true;
                    }

                   if(include) System.out.println("True");
                   else System.out.println("False");
                    break;
                case "Start":
                    String stringAtStart = commandArray[1];
                    boolean start = false;
                    if (sb.toString().contains(stringAtStart)) {
                        int indexOf = sb.indexOf(stringAtStart);
                        if(indexOf==0){
                            start=true;
                        }
                    }
                    if(start) System.out.println("True");
                    else System.out.println("False");
                    break;
                case "Lowercase":
                    sb = new StringBuilder(sb.toString().toLowerCase());

                    System.out.println(sb.toString());
                    break;
                case "FindIndex":
                    String findIndexOf = commandArray[1];
                    int index = sb.lastIndexOf(findIndexOf);

                    System.out.println(index);
                    break;
                case "Remove":
                    int startIndexToRemove = Integer.parseInt(commandArray[1]);
                    int lenghtToRemove = Integer.parseInt(commandArray[2]);
                    sb = sb.replace(startIndexToRemove, startIndexToRemove + lenghtToRemove, "");

                    System.out.println(sb.toString());
                    break;
            }

            input= scanner.nextLine();
        }

    }
}
