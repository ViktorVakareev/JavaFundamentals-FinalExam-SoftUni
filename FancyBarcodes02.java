package com.softuni.fundamentals.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "([@][#]+)([A-Z]{1}[A-Za-z0-9]{4,}[A-Z]{1})\\1";

        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            boolean isDigit = false;
            if (matcher.find()) {
                String match = matcher.group();
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < match.length(); j++) {

                    char element = match.charAt(j);
                    if (Character.isDigit(element)) {
                        isDigit = true;
                        sb.append(String.valueOf(element));
                    }
                }
                if (sb.length()==0) {
                    sb = new StringBuilder("00");
                }
                System.out.println("Product group: " + sb.toString());
            } else {
                System.out.println("Invalid barcode");
            }
        }

    }
}
