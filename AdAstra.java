package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([#|]{1})([A-Za-z ]+)\\1([0-9]{2}[/][0-9]{2}[/][0-9]{2})\\1([0-9]{0,5})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int cal = 0;
        StringBuilder print = new StringBuilder("");

        while (matcher.find()) {
            cal += Integer.parseInt(matcher.group(4));

            print.append(String.format("Item: %s, Best before: %s, Nutrition: %s%n",
                    matcher.group(2), matcher.group(3), matcher.group(4)));
        }
        int days = cal / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);

            System.out.println(print.toString());

    }
}
