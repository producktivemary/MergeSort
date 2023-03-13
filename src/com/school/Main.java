package com.school;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] eingabe = new int[]{5, 1, 8, 3, 9, 2};
        System.out.println(Arrays.toString(eingabe));

        int[] ergebnis = mergeSort(eingabe);
        System.out.println(Arrays.toString(ergebnis));

        // write your code here
    }

    public static int[] mergeSort(int[] eingabe) {
        if (eingabe.length == 1) {
            return eingabe;
        } else {
            // was passiert bei ungeraden Zahlen?
            int teilLaenge = eingabe.length / 2;
            int[] part1 = new int[teilLaenge];
            int[] part2 = new int[eingabe.length - teilLaenge];
            
            System.arraycopy(eingabe, 0, part1, 0, part1.length);
            System.arraycopy(eingabe, teilLaenge, part2, 0, part2.length);
            
            //rekursiv bis einzeln!
            part1 = mergeSort(part1);
            part2 = mergeSort(part2);
            
            // sobald keine weitere Aufteilung möglich ist
            return merge(part1, part2);
            }
        }
// Verstehe nur das net so TODO: programmieren und durchlauf anschauen
    private static int[] merge(int[] part1, int[] part2) {
        int[] ergebnis = new int[part1.length + part2.length];
        int ergebnisCounter = 0;

        while (part1.length > 0 && part2.length > 0) {
            if (part1[0] < part2[0]) {
                ergebnis[ergebnisCounter] = part1[0];
                part1 = removeFirst(part1);
            } else {
                ergebnis[ergebnisCounter] = part2[0];
                part2 = removeFirst(part2);
            }
            ergebnisCounter++;
    }
        int[] rest = part1.length == 0 ? part2 : part1;
        System.arraycopy(rest, 0, ergebnis, ergebnis.length - rest.length, rest.length);
        return ergebnis;

    }

    private static int[] removeFirst(int[] array) {
        return array.length > 1 ? Arrays.copyOfRange(array, 1, array.length) : new int[0];
    }

}
