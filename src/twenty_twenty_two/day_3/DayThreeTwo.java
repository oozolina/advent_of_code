package twenty_twenty_two.day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayThreeTwo {
    public static void main(String[] args) throws IOException {
        var myData = Files.readAllLines(Paths.get("./src/twenty_twenty_two/day_3/data.txt"));
        ArrayList<String> allElves = new ArrayList<>(myData);
        ArrayList<ArrayList<String>> elfGroups = divideAllElvesIntoGroups(allElves, 3);

        ArrayList<Character> commonCharList = new ArrayList<>();
        HashMap<Character, Integer> conversionsCost = createPriorityConversion();

        for (var backpack : elfGroups) {
            String firstElf = backpack.get(0);
            String secondElf = backpack.get(1);
            String thirdElf = backpack.get(2);
            char commonLetter = '0';

            outerLoop:
            for (int i = 0; i < firstElf.length(); i++) {
                for (int j = 0; j < secondElf.length(); j++) {
                    for (int k = 0; k < thirdElf.length(); k++) {
                        if (firstElf.charAt(i) == secondElf.charAt(j) && thirdElf.charAt(k) == secondElf.charAt(j)) {
                            commonLetter = thirdElf.charAt(k);
                            commonCharList.add(commonLetter);
                            break outerLoop;
                        }
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
        System.out.println("Part 2. Sum: " + sum);
    }

    static <T> ArrayList<ArrayList<T>> divideAllElvesIntoGroups(ArrayList<T> listToPart, int numberElementsInGroup) {
        ArrayList<ArrayList<T>> elvesGroups = new ArrayList<>();
        int originalListSize = listToPart.size();
        for (int i = 0; i < originalListSize; i += numberElementsInGroup) {
            elvesGroups.add(new ArrayList<T>(
                    listToPart.subList(i, Math.min(originalListSize, i + numberElementsInGroup)))
            );
        }
        return elvesGroups;
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
