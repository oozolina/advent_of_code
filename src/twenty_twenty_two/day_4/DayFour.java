package twenty_twenty_two.day_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DayFour {

    public static void main(String[] args) throws IOException {
        var myData = Files.readAllLines(Paths.get("./src/twenty_twenty_two/day_4/data.txt"));
        ArrayList<String> data = new ArrayList<>(myData);

        int count = 0;
        int fullOverlapCount = 0;
        
        for (String elvesTeam: data) {
            String[] oneTeam = elvesTeam.split(",");
            String firstElf = oneTeam[0];
            String[] firstRange = firstElf.split("-");
            String secondElf = oneTeam[1];
            String[] secondRange = secondElf.split("-");

            int firstStart = Integer.valueOf(firstRange[0]);
            int firstEnd = Integer.valueOf(firstRange[1]);
            int secondStart = Integer.valueOf(secondRange[0]);
            int secondEnd = Integer.valueOf(secondRange[1]);


            // find if there is overlap
//            if(firstStart > secondEnd
//                    || firstEnd < secondStart){
//                // no overlap
//            } else {
//                count ++;
//            }

            //invert the condition to clean the code (same as above)
            if(firstStart<=secondEnd && firstEnd >=secondStart){
                count++;
            }

            int overlapStart = Math.max(firstStart, secondStart);
            int overlapEnd = Math.min(firstEnd, secondEnd);
            // overlap range is [overlapStart, overlapEnd] and overlap exists if overlapStart <= overlapEnd
            if(overlapStart <= overlapEnd
                    && (firstStart>=secondStart && firstEnd <=secondEnd)
                    || (secondStart>=firstStart && secondEnd<=firstEnd)){
                fullOverlapCount++;
            }

        }
        System.out.println("Part 2. Overlap count: " + count);
        System.out.println("Part 1. Full overlap count: " + fullOverlapCount);
    }
}
