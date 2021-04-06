package com.softuni.fundamentals.FinalExam;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> plantMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArray = scanner.nextLine().split("<->");
            String plantName = inputArray[0];
            double rarity = Double.parseDouble(inputArray[1]);
            double rating = 0.0;
            if (plantMap.containsKey(plantName)){
                rarity+=plantMap.get(plantName)[0];
            }
            double[] plantArray = new double[]{rarity, rating};

            plantMap.put(plantName, plantArray);
        }
        String input = scanner.nextLine();
        int counter = 0;
        double newRating = 0.0;
        while (!input.equals("Exhibition")) {
            String[] commandArray = input.split("[-:]");

            String command = commandArray[0];
            if (!(command.equals("Rate") ||command.equals("Reset") || command.equals("Update"))) {
                System.out.println("error");
                break;
            }
            String plantName = commandArray[1].trim();

            switch (command) {
                case "Rate":
                    counter++;
                    double rating = Double.parseDouble(commandArray[2]);

                    newRating = rating + plantMap.get(plantName)[1]  / counter;
                    plantMap.get(plantName)[1] = newRating;
                    break;
                case "Update":
                    double rarity = Double.parseDouble(commandArray[2]);
                    plantMap.get(plantName)[0] = rarity;
                    break;
                case "Reset":
                    plantMap.get(plantName)[1] = 0.0;
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantMap.entrySet().stream()
                .sorted((a,b)->Double.compare(b.getValue()[0],a.getValue()[0]))
//                .sorted((a,b)->Double.compare(b.getValue()[1],a.getValue()[1]))
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                        e.getKey(), (int) e.getValue()[0], e.getValue()[1]));
    }
}
