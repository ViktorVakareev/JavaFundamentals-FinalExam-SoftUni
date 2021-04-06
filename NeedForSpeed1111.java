package com.softuni.fundamentals.FinalExam;

import java.util.*;

public class NeedForSpeed1111 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> carMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArray = scanner.nextLine().split("\\|");
            String carName = inputArray[0];
            int mileage = Integer.parseInt(inputArray[1]);
            int fuel = Integer.parseInt(inputArray[2]);

            int[] carArray = new int[]{mileage, fuel};
            carMap.put(carName, carArray);
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] commandArray = input.split(" : ");
            String command = commandArray[0];
            String carName = commandArray[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(commandArray[2]);
                    int driveFuel = Integer.parseInt(commandArray[3]);

                    if (driveFuel > carMap.get(carName)[1]) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carMap.get(carName)[0] += distance;
                        carMap.get(carName)[1] -= driveFuel;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, driveFuel);
                    }
                    if (carMap.get(carName)[0] >= 100000) {
                        System.out.printf("Time to sell the %s!%n", carName);
                        carMap.remove(carName);
                    }
                    break;

                case "Refuel":
                    int refillFuel = Integer.parseInt(commandArray[2]);
                    int fuelInTank = carMap.get(carName)[1];

                    if (refillFuel + fuelInTank > 75) {
                        refillFuel = 75 - fuelInTank;
                    }
                    carMap.get(carName)[1] += refillFuel;
                    System.out.printf("%s refueled with %d liters%n", carName, refillFuel);
                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(commandArray[2]);


                    int currentMileage = carMap.get(carName)[0];
                    if (currentMileage - kilometers < 10000) {
                        carMap.get(carName)[0] = 10000;
                        break;
                    }
                    carMap.get(carName)[0] -= kilometers;
                    System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometers);
                    break;
            }
            input = scanner.nextLine();
        }
        carMap.entrySet().stream().
//                Първо сравняваме по Mileage - descending и ако са равни, сравняваме по key- carName!
                sorted((a, b)->{
                    int result=Integer.compare(b.getValue()[0],a.getValue()[0]);
                    if(result==0){
                        result=a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}
