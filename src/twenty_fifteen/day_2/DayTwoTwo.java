package twenty_fifteen.day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DayTwoTwo {

    public static void main(String[] args) throws FileNotFoundException {
        URL url = DayTwoOne.class.getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);

        ArrayList<String> myData = new ArrayList<>();
        while(scanner.hasNextLine()){
            myData.add(scanner.nextLine());
        }
        ArrayList<String[]> boxSeparated = new ArrayList<>();
        for (String dimensions:
                myData) {
            String[] oneBox = dimensions.split("x");
            boxSeparated.add(oneBox);
        }

        int ribbonTotal = 0;
        for (String[] oneBox:
             boxSeparated) {
             ribbonTotal += ribbonNeeded(oneBox);
        }
        System.out.println("Total feet of ribbon: " + ribbonTotal);
    }

    public static int ribbonNeeded(String[] oneBox){
        int height = Integer.parseInt(oneBox[0]);
        int width = Integer.parseInt(oneBox[1]);
        int length = Integer.parseInt(oneBox[2]);
        int[] numericArray = new int[]{height, width, length};
        Arrays.sort(numericArray);
        return 2*(numericArray[0]+numericArray[1]) + height*width*length;
    }
}
