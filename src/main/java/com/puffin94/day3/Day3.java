package main.java.com.puffin94.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Day3 {


    public static void main(String[] args) throws IOException {
        String[] items = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        FileReader fr = new FileReader("src/main/java/com/puffin94/day3/rucksack.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> sharedItems = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String rucksack1 = line.substring(0, line.length() / 2);
            String rucksack2 = line.substring(line.length() / 2);
            ArrayList<String> commonItems = new ArrayList<>();
            for (char item : rucksack1.toCharArray()) {
                if (rucksack2.indexOf(item) > -1 && !commonItems.contains(String.valueOf(item))) {
                    commonItems.add(String.valueOf(item));
                }
            }
            for (String item : commonItems) {
                sharedItems.add(item);
            }
        }
        int totalPriority = totalPriority(sharedItems, items);
        System.out.println("doubles: "+totalPriority);

        //part 2
        FileReader fr2 = new FileReader("src/main/java/com/puffin94/day3/rucksack.txt");
        LineNumberReader lnr = new LineNumberReader(fr2);

        String line1 = null;
        String line2 = null;
        String line3 = null;
        ArrayList<String> badges = new ArrayList<>();
        while ((line = lnr.readLine()) != null) {
            if (line1 == null && line2 == null && line3 == null) {
                lnr.setLineNumber(0);
            }
            if (lnr.getLineNumber() % 3 == 0) {
                line1 = line;
            } else if (lnr.getLineNumber() % 3 == 1) {
                line2 = line;
            } else {
                line3 = line;
                ArrayList<String> commonItems = new ArrayList<>();
                for (char item : line1.toCharArray()) {
                    if (line2.indexOf(item) > -1 && line3.indexOf(item) > -1 && !commonItems.contains(String.valueOf(item))) {
                        commonItems.add(String.valueOf(item));
                    }
                }
                for (String item : commonItems) {
                    badges.add(item);
                }
            }
        }

        System.out.println("Badge: "+totalPriority(badges,items));

    }

    public static int totalPriority(ArrayList<String> sharedItems, String[] items) {
        int totalPriority = 0;
        for (String item : sharedItems) {
            int priority;
            if (Arrays.asList(items).contains(item)) {
                priority = Arrays.asList(items).indexOf(item) + 1;
            } else {
                priority = (Arrays.asList(items).indexOf(item.toLowerCase())) + 27;
            }
            totalPriority += priority;
        }
        return totalPriority;
    }

}
