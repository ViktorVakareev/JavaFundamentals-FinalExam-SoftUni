package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^(.+)>([0-9]+)(\\|)([a-z]+)\\3([A-Z]+)\\3(.+[^<>])<\\1$";
        boolean validPass = false;
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                password.setLength(0);
                password.append(matcher.group(2));
                password.append(matcher.group(4));
                password.append(matcher.group(5));
                password.append(matcher.group(6));
                System.out.printf("Password: %s%n", password.toString());

            } else {
                System.out.println("Try another password!");
            }
        }

    }
}


