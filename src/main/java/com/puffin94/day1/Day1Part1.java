package main.java.com.puffin94.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Day1Part1 {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("src/main/resources/calories.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Elf> elves = new ArrayList<Elf>();
        int count = 0;
        String line;
        Elf elf = null;
        while ((line = br.readLine()) != null) {
            if (count == 0) {
                elf = new Elf(count++);
            } else if (line.equals("")) {
                elves.add(elf);
                elf = new Elf(count++);
                continue;
            }
            elf.setCalorieCount(Integer.parseInt(line));
        }

        elves.sort(Comparator.comparingInt(Elf::getCalorieCount));
        System.out.println(elves.get(elves.size()-1));
        System.out.println(elves.get(elves.size()-1).getCalorieCount()+elves.get(elves.size()-2).getCalorieCount()+
                elves.get(elves.size()-3).getCalorieCount());

    }


}

class Elf {
   private int position;
    private int calorieCount;


    Elf(int position) {
        this.position = position;
        this.calorieCount = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getCalorieCount() {
        return calorieCount;
    }

    public void setCalorieCount(int calorieCount) {
        this.calorieCount += calorieCount;
    }

    @Override
    public String toString() {
        return "Elf{" +
                "position=" + position +
                ", calorieCount=" + calorieCount +
                '}';
    }
}
