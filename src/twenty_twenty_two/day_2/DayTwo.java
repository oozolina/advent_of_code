package twenty_twenty_two.day_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {
    public static void main(String[] args) throws IOException {
        var myData = Files.readAllLines(Paths.get("./src/twenty_twenty_two/day_2/data.txt"));
        ArrayList<Integer> allCompsScore = new ArrayList<>();

        for (var eachRound: myData) {
            eachRound = eachRound.replaceAll("[A|X]", "1");
            eachRound = eachRound.replaceAll("[B|Y]", "2");
            eachRound = eachRound.replaceAll("[C|Z]", "3");

            int myScore = 0;
            int opponentChoice = Character.getNumericValue(eachRound.charAt(0));
            int myChoice = Character.getNumericValue(eachRound.charAt(2));

            if(opponentChoice == myChoice) { // round was a draw
                myScore = myChoice + 3;
            } else if(opponentChoice == 1){
                if(myChoice == 2){
                    myScore = myChoice + 6;
                } else {
                    myScore = myChoice + 0;
                }
            } else if(opponentChoice == 2){
                if(myChoice == 1){
                    myScore = myChoice + 0;
                } else {
                    myScore = myChoice + 6;
                }
            } else if(opponentChoice == 3){
            if(myChoice == 2){
                myScore = myChoice + 0;
            } else {
                myScore = myChoice + 6;
            }
        }
            allCompsScore.add(myScore);
        }

        // Your total score is the sum of your scores for each round.
        int totalScore = allCompsScore.stream().mapToInt(Integer::intValue).sum();
        System.out.println("What would your total score be if everything goes exactly according to your strategy guide? " + totalScore);
    }
}
