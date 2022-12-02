package twenty_twenty_two.day_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayOneAfterRefactoring {


    public static void main(String[] args) throws IOException {
        var myData = Files.readAllLines(Paths.get("./src/twenty_twenty_two/day_1/data.txt"));
        List<Integer> caloriesPerElf = new ArrayList<>();

        int currentCalories = 0;
        for (var foodItem: myData) {
            if(!foodItem.equals("")){
                currentCalories+= Integer.valueOf(foodItem);
            } else {
                caloriesPerElf.add(currentCalories);
                currentCalories = 0;
            }
        }
        Collections.sort(caloriesPerElf, Collections.reverseOrder());

        System.out.println("Part 1: " + caloriesPerElf.get(0));
        System.out.println("Part 2: " + (caloriesPerElf.get(0) + caloriesPerElf.get(1) + caloriesPerElf.get(2)));
        System.out.println("Part 2: " + caloriesPerElf.stream().mapToInt(Integer::intValue).limit(3).sum());
    }
}
