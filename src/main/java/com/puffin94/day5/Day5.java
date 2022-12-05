package main.java.com.puffin94.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Day5 {

    public static ArrayDeque<String> stack1 = new ArrayDeque<>();
    public static ArrayDeque<String> stack2 = new ArrayDeque<>();
    public static ArrayDeque<String> stack3 = new ArrayDeque<>();
    public static ArrayDeque<String> stack4 = new ArrayDeque<>();
    public static ArrayDeque<String> stack5 = new ArrayDeque<>();
    public static ArrayDeque<String> stack6 = new ArrayDeque<>();
    public static ArrayDeque<String> stack7 = new ArrayDeque<>();
    public static ArrayDeque<String> stack8 = new ArrayDeque<>();
    public static ArrayDeque<String> stack9 = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        part1();
        System.out.println();
        part2();

    }

    static void part1() throws IOException {
        initialiseStacks();
        FileReader fr = new FileReader("src/main/java/com/puffin94/day5/rearrangement.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        System.out.println(getTopCrateFromEach());

        while ((line = br.readLine()) != null) {
            String sub = line.substring(5);
            String[] instructions = sub.split(" ");
            int move = Integer.parseInt(instructions[0]);
            int from = Integer.parseInt(instructions[2]);
            int to = Integer.parseInt(instructions[4]);
            ArrayDeque<String> start = stackSelector(from);
            ArrayDeque<String> end = stackSelector(to);


            for (int i = 0; i < move; i++) {
                end.addFirst(start.removeFirst());
            }
        }
        System.out.println(getTopCrateFromEach());
    }

    static void part2() throws IOException {

        initialiseStacks();

        FileReader fr = new FileReader("src/main/java/com/puffin94/day5/rearrangement.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        System.out.println(getTopCrateFromEach());
        
        while ((line = br.readLine()) != null) {
            String sub = line.substring(5);
            String[] instructions = sub.split(" ");
            int move = Integer.parseInt(instructions[0]);
            int from = Integer.parseInt(instructions[2]);
            int to = Integer.parseInt(instructions[4]);
            ArrayDeque<String> start = stackSelector(from);
            ArrayDeque<String> end = stackSelector(to);
            ArrayDeque<String> temp = new ArrayDeque<>();

            for (int i = 0; i < move; i++) {
                temp.add(start.removeFirst());
            }

            while (temp.size() != 0) {
                end.addFirst(temp.removeLast());
            }
        }
        System.out.println(getTopCrateFromEach());

    }


    static ArrayDeque<String> stackSelector(int stackNumber) {
        switch (stackNumber) {
            case 1:
                return stack1;
            case 2:
                return stack2;
            case 3:
                return stack3;
            case 4:
                return stack4;
            case 5:
                return stack5;
            case 6:
                return stack6;
            case 7:
                return stack7;
            case 8:
                return stack8;
            case 9:
                return stack9;
            default:
                return new ArrayDeque<>();
        }
    }

    static void initialiseStacks() {
        initialiseStack(stack1, 1);
        initialiseStack(stack2, 2);
        initialiseStack(stack3, 3);
        initialiseStack(stack4, 4);
        initialiseStack(stack5, 5);
        initialiseStack(stack6, 6);
        initialiseStack(stack7, 7);
        initialiseStack(stack8, 8);
        initialiseStack(stack9, 9);
    }

    static void initialiseStack(ArrayDeque stack, int number) {
        String[] one = {"C", "F", "B", "L", "D", "P", "Z", "S"};
        String[] two = {"B", "W", "H", "P", "G", "V", "N"};
        String[] three = {"G", "J", "B", "W", "F"};
        String[] four = {"S", "C", "W", "L", "F", "N", "J", "G"};
        String[] five = {"H", "S", "M", "P", "T", "L", "J", "W"};
        String[] six = {"S", "F", "G", "W", "C", "B"};
        String[] seven = {"W", "B", "Q", "M", "P", "T", "H"};
        String[] eight = {"T", "W", "S", "F"};
        String[] nine = {"R", "C", "N"};

        String[] stackContents;
        switch (number) {
            case 1:
                stackContents = one;
                break;
            case 2:
                stackContents = two;
                break;
            case 3:
                stackContents = three;
                break;
            case 4:
                stackContents = four;
                break;
            case 5:
                stackContents = five;
                break;
            case 6:
                stackContents = six;
                break;
            case 7:
                stackContents = seven;
                break;
            case 8:
                stackContents = eight;
                break;
            case 9:
                stackContents = nine;
                break;
            default:
                stackContents = new String[1];
        }
        stack.clear();
        for (String crate : stackContents) {
            stack.add(crate);
        }

    }

    static String getTopCrateFromEach() {
        StringBuilder topCrates = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            topCrates.append(stackSelector(i).peekFirst());
        }
        return topCrates.toString();
    }
}
