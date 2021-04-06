package com.softuni.fundamentals.FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([@#]{1})([A-Za-z]{3,})(\\1{2})([A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

//        StringBuilder sb = new StringBuilder();
//        StringBuilder sbReversed = new StringBuilder();
        int counter = 0;
        List<String> printList = new ArrayList<>();
        boolean isValid = false;

        while (matcher.find()) {
            counter++;
            StringBuilder sb = new StringBuilder(matcher.group(2));
            String reversed =sb.reverse().toString();
            StringBuilder sbReversed = new StringBuilder(matcher.group(4));
            if (sbReversed.toString().equals(reversed)) {
                String print = String.format("%s <=> %s", sb.reverse().toString(), sbReversed.toString());
                printList.add(print);
                isValid = true;
            }

        }
        if (counter == 0) {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        } else {
            if (isValid) {
                System.out.printf("%d word pairs found!%n", counter);
                System.out.printf("The mirror words are:%n%s", String.join(", ", printList));
            } else {
                System.out.printf("%d word pairs found!%n", counter);
                System.out.println("No mirror words!");
            }
        }

    }
}
