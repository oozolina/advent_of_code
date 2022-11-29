package twenty_fifteen.day_1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class DayOneOne {

    public static void main(String[] args) throws IOException {
        String content = Files.readString(Paths.get(".\\src\\twenty_fifteen\\day_1\\data.txt"));
        String[] spitMyContent = content.split("");
        ArrayList<String> myData = new ArrayList<>(Arrays.asList(spitMyContent));

        int startFloor = 0;
        for (int i=0; i < myData.size(); i++) {
            if(myData.get(i).equals("(")){
                startFloor++;
            }
            if(myData.get(i).equals(")")){
                startFloor--;
            }
        }
        System.out.println("To what floor do the instructions take Santa? " + startFloor);
    }
}
