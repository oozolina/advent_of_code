package twenty_twenty_two.day_6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DaySix {

    public static void main(String[] args) throws IOException {
        String data = Files.readString(Paths.get("./src/twenty_twenty_two/day_6/data.txt"));
       // String data = "bvwbjplbgvbhsrlpgdmjqwftvncz";

        //for part two replace i+4 to i+14 and decrease the condition for i accordingly
        for (int i = 0; i < data.length()-5; i++) {
            String uniqueLetters = data.substring(i, i+4);
            if(checkDuplicatesInString(uniqueLetters)){
                System.out.println("How many characters need to be processed before the first start-of-packet marker is detected? " + (i+4));
                return;
            }
        }
    }

    public static boolean checkDuplicatesInString(String uniqueLetters){
        for (int j = 0; j < uniqueLetters.length(); j++) {
            for (int k = j+1; k < uniqueLetters.length(); k++) {
                if(uniqueLetters.charAt(j) == uniqueLetters.charAt(k)){
                    return false;
                }
            }
        }
        return true;
    }
}
