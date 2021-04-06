package com.softuni.fundamentals.FinalExam;

import java.util.*;

public class ThePianist03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String[]> piecesMap = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String[] piecesArray = scanner.nextLine().split("\\|");
            String piece = piecesArray[0];
            String composer = piecesArray[1];
            String keyM = piecesArray[2];
            String[] pieceValues = new String[]{composer, keyM};

            piecesMap.put(piece, pieceValues);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] commandArray = input.split("\\|");
            String command = commandArray[0];
            String piece = commandArray[1];

            switch (command) {
                case "Add":
                    String composer = commandArray[2];
                    String keyM = commandArray[3];

                    if (piecesMap.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, keyM);
                        String[] newValues = new String[]{composer,keyM};
                        piecesMap.put(piece,newValues);

                    }
                    break;
                case "Remove":
                    if (piecesMap.containsKey(piece)) {
                        System.out.printf("Successfully removed %s!%n", piece);
                        piecesMap.remove(piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String keyMNew = commandArray[2];

                    if (piecesMap.containsKey(piece)) {
                        System.out.printf("Changed the key of %s to %s!%n", piece, keyMNew);
                        String[] newValues = new String[]{piecesMap.get(piece)[0], keyMNew};
                        piecesMap.put(piece, newValues);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;

            }
            input = scanner.nextLine();
        }

        piecesMap.entrySet().stream()
                .sorted((a,b)->a.getKey().compareTo(b.getKey()))
//                .sorted((a,b)->a.getValue()[0].compareTo(b.getValue()[0]))
                .forEach(e-> System.out.printf("%s -> Composer: %s, Key: %s%n",e.getKey(),e.getValue()[0],e.getValue()[1]));
    }
}
