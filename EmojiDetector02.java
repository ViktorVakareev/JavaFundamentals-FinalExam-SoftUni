package com.softuni.fundamentals.FinalExam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([:*]{2})([A-Z][a-z]{2,})\\1";

        String text = scanner.nextLine();
//        BigInteger coolNumberBI = new BigInteger("1");
        double coolNumber = 0.0;
        String match = "";
        int counter = 0;

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            String symbolStr=Character.toString(symbol);
            if (Character.isDigit(symbol)) {
//                BigInteger symBI = new BigInteger("symbolStr");
                int sym = Character.getNumericValue(symbol);
                coolNumber = 1.0 * sym;
//                coolNumberBI = coolNumberBI.multiply(symBI);
            }
        }
        System.out.printf("Cool threshold: %.0f%n", coolNumber);
//        System.out.printf("Cool threshold: %s%n", coolNumberBI);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> coolList = new ArrayList<>();

        while (matcher.find()) {
            double sum = 0.0;
            match = matcher.group();
            counter++;
            for (int i = 0; i < match.length(); i++) {
                char symbol = match.charAt(i);

                if (Character.toString(symbol).equals(":") || Character.toString(symbol).equals("*")) {
                    continue;
                }
                sum += (int) symbol;
            }
            if (sum > coolNumber) {
                coolList.add(match);
            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);
        if (coolList.isEmpty()) {
            return;
        } else {
            for (String cool : coolList) {
                System.out.println(cool);
            }
        }
    }
}
