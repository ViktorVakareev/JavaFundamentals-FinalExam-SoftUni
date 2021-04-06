package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Final2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regexUser = "(U\\$)([A-Z][a-z]{2,})\\1";
        String regexPass = "(P@\\$)([a-z]{5,}[0-9]+)\\1";
        int counter = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern patternUser = Pattern.compile(regexUser);
            Pattern patternPass = Pattern.compile(regexPass);
            Matcher matcherUser = patternUser.matcher(input);
            Matcher matcherPass = patternPass.matcher(input);

            if (matcherPass.find() && matcherUser.find()) {
                counter++;
                System.out.printf("Registration was successful%nUsername: %s, Password: %s%n",
                        matcherUser.group(2),matcherPass.group(2));
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d",counter);
    }
}
