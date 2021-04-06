package com.softuni.fundamentals.FinalExam;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Final3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, int[]> peopleMap = new TreeMap<>();

        while (!input.equals("Results")) {
            String[] commandArray = input.split(":");
            String command = commandArray[0];

            switch (command) {
                case "Add":
                    String personToAdd = commandArray[1];
                    int health = Integer.parseInt(commandArray[2]);
                    int energy = Integer.parseInt(commandArray[3]);

                    if (peopleMap.containsKey(personToAdd)) {
                        peopleMap.get(personToAdd)[0] += health;
                        break;
                    }

                    int[] peopleArray = new int[]{health, energy};
                    peopleMap.put(personToAdd, peopleArray);
                    break;

                case "Attack":
                    String attacker = commandArray[1];
                    String defender = commandArray[2];
                    int damage = Integer.parseInt(commandArray[3]);

                    if (!peopleMap.containsKey(attacker) || !peopleMap.containsKey(defender)) {
                        break;
                    }
                    peopleMap.get(defender)[0] -= damage;
                    if (peopleMap.get(defender)[0] <= 0) {
                        System.out.printf("%s was disqualified!%n", defender);
                        peopleMap.remove(defender);
                    }

                    if (peopleMap.get(attacker)[1] > 0) {
                        peopleMap.get(attacker)[1] -= 1;
                        if (peopleMap.get(attacker)[1] == 0) {
                            System.out.printf("%s was disqualified!%n", attacker);
                            peopleMap.remove(attacker);
                        }
                    } else {
                        System.out.printf("%s was disqualified!%n", attacker);
                        peopleMap.remove(attacker);
                    }
                    break;

                case "Delete":
                    String username = commandArray[1];
                    if (username.equals("All")) {
                        peopleMap.clear();
                    } else if (peopleMap.containsKey(username)) {
                        peopleMap.remove(username);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        if (peopleMap.isEmpty()) {
            System.out.printf("People count: %d", peopleMap.size());
        } else {
            System.out.printf("People count: %d%n", peopleMap.size());
            peopleMap.entrySet().stream()
                    .sorted((a, b) -> {
                        int result = Integer.compare(b.getValue()[0], a.getValue()[0]);
                        if (result == 0) {
                            result = Integer.compare(b.getValue()[1], a.getValue()[1]);
                        }
                        return result;
                    })
                    .forEach(e -> System.out.printf("%s - %d - %d%n",
                            e.getKey(), e.getValue()[0], e.getValue()[1]));

        }
    }
}
