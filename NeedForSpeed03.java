package com.softuni.fundamentals.FinalExam;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeed03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> carsMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArray = scanner.nextLine().split("\\|");
            String carName = inputArray[0];
            int mileage = Integer.parseInt(inputArray[1]);
            int fuel = Integer.parseInt(inputArray[2]);
            int[] carsArray = new int[]{mileage, fuel};

            carsMap.put(carName, carsArray);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] commandArray = input.split(" : ");
            String command = commandArray[0];
            String carName = commandArray[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(commandArray[2]);
                    int fuel = Integer.parseInt(commandArray[3]);
                    int carFuel = carsMap.get(carName)[1];
                    int miles = carsMap.get(carName)[0];

                    if (fuel > carFuel) {
                        System.out.println("Not enough fuel to make that ride");
                        break;
                    } else {
                        carsMap.get(carName)[1] -= fuel;
                        carsMap.get(carName)[0]+=distance;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, fuel);
                    }

                    if (carsMap.get(carName)[0] >= 100000) {
                        System.out.printf("Time to sell the %s!%n", carName);
                        carsMap.remove(carName);
                    }
                    break;
                case "Refuel":
                    int reFuel = Integer.parseInt(commandArray[2]);
                    int fuelInTank = carsMap.get(carName)[1];

                    if (reFuel + carsMap.get(carName)[1] > 75) {
                        reFuel = 75 - carsMap.get(carName)[1];
                    }
                    carsMap.get(carName)[1] += reFuel;
                    System.out.printf("%s refueled with %d liters%n", carName, reFuel);
                    break;
                case "Revert":
                    int kilometres = Integer.parseInt(commandArray[2]);
                    int decreasedMileage = carsMap.get(carName)[0];
                    carsMap.get(carName)[0] -= kilometres;
                    if (carsMap.get(carName)[0] <= 10000) {
                        carsMap.get(carName)[0] = 10000;
                        break;
                    }
                    System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometres);
                    break;

            }

            input = scanner.nextLine();
        }
        carsMap.entrySet().stream()
                .sorted((a,b)->Integer.compare(b.getValue()[0],a.getValue()[0]))

                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}
