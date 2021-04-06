package com.softuni.fundamentals.FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([=/]{1})[A-Z]{1}[A-Za-z]{2,}\\1";
        int points = 0;
        List<String> destinations = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String match= matcher.group();
            match=match.replaceAll("[=/]{1}","");
//            match.replaceAll("/","");
            destinations.add(match);
            points+=match.length();
        }

        System.out.printf("Destinations: %s%n", String.join(", ", destinations));
        System.out.printf("Travel Points: %d", points);
    }
}
