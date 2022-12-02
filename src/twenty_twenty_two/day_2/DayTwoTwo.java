package twenty_twenty_two.day_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DayTwoTwo {
    public static void main(String[] args) throws IOException {
        var myData = Files.readAllLines(Paths.get("./src/twenty_twenty_two/day_2/data.txt"));
        ArrayList<Integer> allCompsScore = new ArrayList<>();
        for (var eachRound: myData) {
            eachRound = eachRound.replaceAll("[A]", "1");
            eachRound = eachRound.replaceAll("[B]", "2");
            eachRound = eachRound.replaceAll("[C]", "3");

            char howRoundNeedsToEnd = eachRound.charAt(2);
            int opponentChoice = Character.getNumericValue(eachRound.charAt(0));
            int myChoice = 0;
            int myScore = 0;
            //game logic
            // 1 beat 3
            // 2 beat 1
            // 3 beat 2
            switch (howRoundNeedsToEnd){
                case 'X':
                    if(opponentChoice == 1){
                        myChoice = 3;
                    } else if(opponentChoice == 2){
                        myChoice = 1;
                    } else if(opponentChoice == 3) {
                        myChoice = 2;
                    }
                    myScore = myChoice;
                    break;
                case 'Y':
                    myChoice = opponentChoice;
                    myScore = myChoice + 3;
                    break;
                case 'Z':
                    if(opponentChoice == 1){
                        myChoice = 2;
                    } else if(opponentChoice == 2){
                        myChoice = 3;
                    } else if(opponentChoice == 3){
                        myChoice = 1;
                    }
                    myScore = myChoice + 6;
                    break;
            }
            allCompsScore.add(myScore);
        }

        int totalScore = allCompsScore.stream().mapToInt(Integer::intValue).sum();
        System.out.println("What would your total score be if everything goes exactly according to your strategy guide? " + totalScore);
    }
}
