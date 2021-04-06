package com.softuni.fundamentals.FinalExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, int[]> citiesMap = new HashMap<>();

        while (!input.equals("Sail")) {
            String[] citiesArray = input.split("[|]{2}");
            String city = citiesArray[0];
            int population = Integer.parseInt(citiesArray[1]);
            int gold = Integer.parseInt(citiesArray[2]);


            if (citiesMap.containsKey(city)) {
                population += citiesMap.get(city)[0];
                gold += citiesMap.get(city)[1];
            }
            int[] cityValue = new int[]{population, gold};

            citiesMap.put(city, cityValue);

            input = scanner.nextLine();
        }

        String commands = scanner.nextLine();

        while (!commands.equals("End")) {
            String[] commandArray = commands.split("=>");
            String command = commandArray[0];
            String town = commandArray[1];

            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(commandArray[2]);
                    int gold = Integer.parseInt(commandArray[3]);

                    citiesMap.get(town)[0] -= people;
                    citiesMap.get(town)[1] -= gold;
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                            town, gold, people);

                    if (citiesMap.get(town)[0] <= 0 || citiesMap.get(town)[1] <= 0) {
                        citiesMap.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }

                    break;

                case "Prosper":
                    int goldProsper = Integer.parseInt(commandArray[2]);
                    if (goldProsper < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }

                    citiesMap.get(town)[1] += goldProsper;
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldProsper, town, citiesMap.get(town)[1]);
                    break;

            }
            commands = scanner.nextLine();
        }
        if (citiesMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesMap.size());

            citiesMap.entrySet().stream()
                    .sorted((a, b) -> Integer.compare(b.getValue()[1], a.getValue()[1]))
//                    .sorted((a,b)->b.getKey().compareTo(a.getKey()))
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            e.getKey(), e.getValue()[0], e.getValue()[1]));

        }

    }
}
