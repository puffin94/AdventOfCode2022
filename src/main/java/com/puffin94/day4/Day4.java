package main.java.com.puffin94.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/main/java/com/puffin94/day4/assignments.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int encased = 0;
        int overlapped = 0;
        while ((line = br.readLine()) != null) {
            String[] groups = line.split(",");
            String group1 = groups[0];
            String group2 = groups[1];
            String[] g1 = group1.split("-");
            String[] g2 = group2.split("-");
            int g1Start = Integer.parseInt(g1[0]);
            int g1End = Integer.parseInt(g1[1]);
            int g2Start = Integer.parseInt(g2[0]);
            int g2End = Integer.parseInt(g2[1]);

            // Part 1
            if ((g1Start <= g2Start && g1End >= g2End) || (g2Start <= g1Start && g2End >= g1End)) {
                encased++;
            }

            // Part 2
            if ((g1End>=g2Start && g1End<=g2End) ||
                    (g2End>=g1Start && g2End<=g1End)
            ) {
                overlapped++;
            }
        }
        System.out.println(encased);
        System.out.println(overlapped);
    }
}
