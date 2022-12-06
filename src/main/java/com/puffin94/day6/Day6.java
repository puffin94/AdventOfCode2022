package main.java.com.puffin94.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day6 {

    //take input buffer in
    //change to char array
    //boolean flag
    //for loop with values 0,1,2,3 all plus i
    //i<inputlength-5
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("src/main/java/com/puffin94/day6/transmission.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        char[] transmission = line.toCharArray();

        //part 1 find start of transmission marker
        for (int i = 0; i < transmission.length - 5; i++) {
            char a = transmission[0 + i];
            char b = transmission[1 + i];
            char c = transmission[2 + i];
            char d = transmission[3 + i];

            if (a != b && a != c && a != d && b != c && b != d && c != d) {
                System.out.println("Packet starts at index " + (i + 4));
                break;
            }
        }

        //part 2 find start of message marker
        for (int z = 0; z < transmission.length - 14; z++) {
            char a = transmission[0 + z];
            char b = transmission[1 + z];
            char c = transmission[2 + z];
            char d = transmission[3 + z];
            char e = transmission[4 + z];
            char f = transmission[5 + z];
            char g = transmission[6 + z];
            char h = transmission[7 + z];
            char i = transmission[8 + z];
            char j = transmission[9 + z];
            char k = transmission[10 + z];
            char l = transmission[11 + z];
            char m = transmission[12 + z];
            char n = transmission[13 + z];
            if (a != b && a != c && a != d && a != e && a != f && a != g && a != h && a != i && a != j && a != k && a != l && a != m && a != n &&
                    b != c && b != d && b != e && b != f && b != g && b != h && b != i && b != j && b != k && b != l && b != m && b != n &&
                    c != d && c != e && c != f && c != g && c != h && c != i && c != j && c != k && c != l && c != m && c != n &&
                    d != e && d != f && d != g && d != h && d != i && d != j && d != k && d != l && d != m && d != n &&
                    e != f && e != g && e != h && e != i && e != j && e != k && e != l && e != m && e != n &&
                    f != g && f != h && f != i && f != j && f != k && f != l && f != m && f != n &&
                    g != h && g != i && g != j && g != k && g != l && g != m && g != n &&
                    h != i && h != j && h != k && h != l && h != m && h != n &&
                    i != j && i != k && i != l && i != m && i != n &&
                    j != k && j != l && j != m && j != n &&
                    k != l && k != m && k != n &&
                    l != m && l != n &&
                    m != n) {
                System.out.println("Message starts at index " + (z + 14));
                break;
            }
        }


    }
}
