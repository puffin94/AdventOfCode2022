package main.java.com.puffin94.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day2 {

    //A=Rock, B=Paper, C=Scissors
    //X=Rock, Y=Paper, Z=Scissors

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/main/java/com/puffin94/day2/rockPaperScissors.txt");
        BufferedReader br = new BufferedReader(fr);
        HashMap<String,String> rps = new HashMap<>();
        HashMap<String,Integer> points = new HashMap<>();
        rps.put("A","Rock");
        rps.put("B","Paper");
        rps.put("C","Scissors");
        rps.put("X","Rock");
        rps.put("Y","Paper");
        rps.put("Z","Scissors");
        points.put("Rock",1);
        points.put("Paper",2);
        points.put("Scissors",3);
        points.put("Win",6);
        points.put("Draw",3);
        points.put("Lose",0);
        String line;
        int firstScore = 0;
        int secondScore = 0;
        while((line = br.readLine())!=null){
            String[] split = line.split(" ");
            String opponent= rps.get(split[0]);
            String you=rps.get(split[1]);
            String result="";

            if(opponent.equals(you)){
                result="Draw";
            } else if ((you.equals("Scissors") && opponent.equals("Paper")) ||
                    (you.equals("Paper")&&opponent.equals("Rock"))||
                    (you.equals("Rock")&&opponent.equals("Scissors"))) {
                result = "Win";
            }else{
                result = "Lose";
            }
            int roundScore = points.get(result)+ points.get(you);
            firstScore +=roundScore;

            //part2
            you = split[1];
            if(you.equals("X")){
                result = "Lose";
            } else if (you.equals("Y")) {
                result = "Draw";
            }else{
                result = "Win";
            }

            if(result.equals("Win")){
                switch(opponent){
                    case "Rock":
                        you = "Paper";
                        break;
                    case "Paper":
                        you = "Scissors";
                        break;
                    case "Scissors":
                        you = "Rock";
                        break;
                }
            } else if (result.equals("Lose")) {
                switch(opponent){
                    case "Rock":
                        you = "Scissors";
                        break;
                    case "Paper":
                        you = "Rock";
                        break;
                    case "Scissors":
                        you = "Paper";
                        break;
                }
            }else{
                you = opponent;
            }
            roundScore = points.get(result)+ points.get(you);
            secondScore+=roundScore;
        }
        System.out.println("First Score: "+firstScore);
        System.out.println("Second Score: "+secondScore);
    }
}
