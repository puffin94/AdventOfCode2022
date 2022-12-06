package main.java.com.puffin94.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day6 {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("src/main/java/com/puffin94/day6/transmission.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        char[] transmission = line.toCharArray();

        //part 1 find start of transmission marker
        System.out.println("Packet ends at index " + getEndingIndexOfDuplicateFreeSequence(transmission, 4));
        //part 2 find start of message marker
        System.out.println("Message ends at index " + getEndingIndexOfDuplicateFreeSequence(transmission, 14));
    }

    public static int getEndingIndexOfDuplicateFreeSequence(char[] sequence, int length) {
        for (int z = 0; z < sequence.length - length; z++) {
            char[] message = Arrays.copyOfRange(sequence, z, z + length);
            if (!arrayContainsDuplicates(message)) {
                return z + length;
            }
        }
        return 0;
    }

    public static boolean arrayContainsDuplicates(char[] array) {
        boolean containsDuplicates = false;

        for (int i = 0; i < array.length; i++) {
            char[] temp = new char[array.length - 1];
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (j != i) {
                    temp[count++] = array[j];
                }
            }
            Arrays.sort(temp);
            int search = Arrays.binarySearch(temp, array[i]);
            if (search >= 0) {
                containsDuplicates = true;
                break;
            }
        }
        return containsDuplicates;
    }
}
