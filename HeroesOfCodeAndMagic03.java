package com.softuni.fundamentals.FinalExam;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndMagic03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> heroesMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArray = scanner.nextLine().split(" ");
            String heroName = inputArray[0];
            int HP = Integer.parseInt(inputArray[1]);
            int MP = Integer.parseInt(inputArray[2]);
            int[] heroesArray = new int[]{HP, MP};

            heroesMap.put(heroName, heroesArray);
        }
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandArray = input.split(" - ");
            String command = commandArray[0];
            String heroName = commandArray[1];

            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(commandArray[2]);
                    String spell = commandArray[3];

                    if (neededMP <= heroesMap.get(heroName)[1]) {
                        heroesMap.get(heroName)[1] -= neededMP;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spell, heroesMap.get(heroName)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spell);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandArray[2]);
                    String attacker = commandArray[3];

                    if(damage<heroesMap.get(heroName)[0]){
                        heroesMap.get(heroName)[0]-=damage;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName,damage,attacker,heroesMap.get(heroName)[0]);
                    }else {

                        System.out.printf("%s has been killed by %s!%n",heroName,attacker);
                        heroesMap.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amountRecharge = Integer.parseInt(commandArray[2]);

                    if ((amountRecharge + heroesMap.get(heroName)[1]) > 200) {
                        amountRecharge = 200 - heroesMap.get(heroName)[1];
                    }
                    heroesMap.get(heroName)[1] += amountRecharge;
                    System.out.printf("%s recharged for %d MP!%n", heroName, amountRecharge);
                    break;
                case "Heal":
                    int amount = Integer.parseInt(commandArray[2]);

                    if ((amount + heroesMap.get(heroName)[0]) > 100) {
                        amount = 100 - heroesMap.get(heroName)[0];
                    }
                    heroesMap.get(heroName)[0] += amount;
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                    break;
            }

            input = scanner.nextLine();
        }
        heroesMap.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue()[0], a.getValue()[0]))
                .forEach(e -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", e.getKey(), e.getValue()[0], e.getValue()[1]));

    }
}
