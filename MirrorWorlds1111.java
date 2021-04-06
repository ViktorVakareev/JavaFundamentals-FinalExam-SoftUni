package com.softuni.fundamentals.FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWorlds1111 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([@#])(?<word1>[A-za-z]{3,})\\1\\1(?<word2>[A-za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> mirrorWordsList = new ArrayList<>();
        int counter = 0;
        boolean isMirror = false;

        while (matcher.find()) {
            String word1 = matcher.group("word1");
            String word2 = matcher.group("word2");
            StringBuilder reversedWord = new StringBuilder(word2);
            String reversedWord2 = reversedWord.reverse().toString();
            counter++;
            if (word1.equals(reversedWord2)) {

                String printWord = word1 + " <=> " + word2;
                mirrorWordsList.add(printWord);
                isMirror = true;
            }
        }
        if (counter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", counter);
        }
        if (!isMirror) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", mirrorWordsList));
        }

    }
}
