package twenty_twenty_two.day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayThreeOne {

    public static void main(String[] args) throws IOException {
        var myData = Files.readAllLines(Paths.get("./src/twenty_twenty_two/day_3/data.txt"));
        ArrayList<Character> commonCharList = new ArrayList<>();
        HashMap<Character, Integer> conversionsCost = createPriorityConversion();

        for (String backpack : myData) {
            String rightCompartment = backpack.substring(0, backpack.length() / 2);
            String leftCompartment = backpack.substring(backpack.length() / 2);
            char commonLetter = '0';

            outerLoop:
            for (int i = 0; i < rightCompartment.length(); i++) {
                for (int j = 0; j < leftCompartment.length(); j++) {
                    if (rightCompartment.charAt(i) == leftCompartment.charAt(j)) {
                        commonLetter = leftCompartment.charAt(j);
                        commonCharList.add(commonLetter);
                        break outerLoop;
                    }
                }
            }
        }

        int sum = 0;
        for (char letter : commonCharList) {
            for (Character key : conversionsCost.keySet()) {
                if (letter == key) {
                    sum += conversionsCost.get(key);
                }
            }
        }
        System.out.println("Part 1. Sum: " + sum);
    }

    public static HashMap<Character, Integer> createPriorityConversion() {
        Map<Character, Integer> map = Stream.of(new Object[][]{
                {'a', 1},
                {'b', 2},
                {'c', 3},
                {'d', 4},
                {'e', 5},
                {'f', 6},
                {'g', 7},
                {'h', 8},
                {'i', 9},
                {'j', 10},
                {'k', 11},
                {'l', 12},
                {'m', 13},
                {'n', 14},
                {'o', 15},
                {'p', 16},
                {'q', 17},
                {'r', 18},
                {'s', 19},
                {'t', 20},
                {'u', 21},
                {'v', 22},
                {'w', 23},
                {'x', 24},
                {'y', 25},
                {'z', 26},

                {'A', 27},
                {'B', 28},
                {'C', 29},
                {'D', 30},
                {'E', 31},
                {'F', 32},
                {'G', 33},
                {'H', 34},
                {'I', 35},
                {'J', 36},
                {'K', 37},
                {'L', 38},
                {'M', 39},
                {'N', 40},
                {'O', 41},
                {'P', 42},
                {'Q', 43},
                {'R', 44},
                {'S', 45},
                {'T', 46},
                {'U', 47},
                {'V', 48},
                {'W', 49},
                {'X', 50},
                {'Y', 51},
                {'Z', 52},
        }).collect(Collectors.toMap(data -> (Character) data[0], data -> (Integer) data[1]));
        HashMap<Character, Integer> conversionsCost = new HashMap<>(map);
        return conversionsCost;
    }
}
