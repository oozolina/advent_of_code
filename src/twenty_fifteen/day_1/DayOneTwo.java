package twenty_fifteen.day_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class DayOneTwo {

    public static void main(String[] args) throws IOException {
        String data = Files.readString(Paths.get(".\\src\\twenty_fifteen\\day_1\\data.txt"));
        String[] arrData = data.split("");

        ArrayList<String> myData = new ArrayList<>(Arrays.asList(arrData));
        System.out.println("What is the position of the character that causes Santa to first enter the basement? " + returnPosition(myData));
    }

    public static int returnPosition(ArrayList<String> myData){
        int currentFloor = 0;
        for (int i=0; i < myData.size(); i++) {
            switch (myData.get(i)){
                case "(": currentFloor++;
                    if(currentFloor==-1){
                        return i+1;
                    }
                    break;
                case ")": currentFloor--;
                    if(currentFloor==-1){
                        return i+1;
                    }
                    break;
            }
        }
        return -1;
    }
}
