package twenty_twenty_two.day_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class DayFiveOne {

    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<String>> crates = new ArrayList<>();

        // test crates
//        crates.add(new ArrayList<>(Arrays.asList("Z", "N")));
//        crates.add(new ArrayList<>(Arrays.asList("M", "C", "D")));
//        crates.add(new ArrayList<>(Arrays.asList("P")));

//        //data crates
        crates.add(new ArrayList<>(Arrays.asList("W", "M", "L", "F"))); //1
        crates.add(new ArrayList<>(Arrays.asList("B", "Z", "V", "M", "F"))); //2
        crates.add(new ArrayList<>(Arrays.asList("H", "V", "R", "S", "L", "Q"))); //3
        crates.add(new ArrayList<>(Arrays.asList("F", "S", "V", "Q", "P", "M", "T", "J"))); //4
        crates.add(new ArrayList<>(Arrays.asList("L", "S", "W"))); //5
        crates.add(new ArrayList<>(Arrays.asList("F", "V", "P", "M", "R", "J", "W"))); //6
        crates.add(new ArrayList<>(Arrays.asList("J", "Q", "C", "P", "N", "R", "F"))); // 7
        crates.add(new ArrayList<>(Arrays.asList("V", "H", "P", "S", "Z", "W", "R", "B"))); //8
        crates.add(new ArrayList<>(Arrays.asList("B", "M", "J", "C", "G", "H", "Z", "W"))); //9

        //var myData = Files.readAllLines(Paths.get("./src/twenty_twenty_two/day_5/data_rearrangement_procedure.txt"));
        var myData = Files.readAllLines(Paths.get("./src/twenty_twenty_two/day_5/data_rearrangement_procedure.txt"));
        ArrayList<String> data = new ArrayList<>(myData); // moves
        for (var command : data) {
            String[] arrayOfCommands = command.split(" ");
            int numberOfMoves = Integer.valueOf(arrayOfCommands[1]);
            int fromCrate = Integer.valueOf(arrayOfCommands[3]);
            int toCrate = Integer.valueOf(arrayOfCommands[5]);
            for (int i = 1; i <= numberOfMoves; i++) {
                ArrayList<String> fromList = crates.get(fromCrate - 1);
                ArrayList<String> toList = crates.get(toCrate - 1);
                String elementToMove = fromList.get(fromList.size() - 1);
                toList.add(elementToMove);
                fromList.remove(fromList.size() - 1);
            }
        }

        String finalResult = "";
        for (var crateStack : crates) {
            finalResult += crateStack.get(crateStack.size() - 1);
        }
        System.out.println(finalResult);

    }
}
