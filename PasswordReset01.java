package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;

public class PasswordReset01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        StringBuilder sb = new StringBuilder(password);
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] commandArray = input.split("\\s+");
            String command = commandArray[0];
            String current = "";
            switch (command) {
                case "TakeOdd":
                    for (int i = 1; i < sb.length(); i += 2) {

                        String element = String.valueOf(password.charAt(i));
                        current += element;

                    }
                    sb = new StringBuilder(current);
                    System.out.println(sb.toString());
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandArray[1]);
                    int length = Integer.parseInt(commandArray[2]);

                    sb.replace(index,index+length,"");
                    System.out.println(sb.toString());
                    break;
                case "Substitute":
                    String substring = commandArray[1];
                    String substitute = commandArray[2];
                    if (sb.toString().contains(substring)) {
                        String sbCurrent = sb.toString();
                        sbCurrent = sbCurrent.replaceAll(substring, substitute);
                        sb=new StringBuilder(sbCurrent);
                        System.out.println(sb.toString());
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;

            }

            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + sb.toString());
    }
}
