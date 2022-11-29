package twenty_fifteen.day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DayTwoOne {

    public static int smallestBoxSide(int sizeOne, int sizeTwo, int sizeThree){
        int[] compare = new int[]{sizeOne, sizeTwo, sizeThree};
        return Arrays.stream(compare).reduce((a, b) -> a < b ? a : b).getAsInt();
    }

    public static void main(String[] args) throws FileNotFoundException {
        URL url = DayTwoOne.class.getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);

        ArrayList<String> myData = new ArrayList<>();
        while(scanner.hasNextLine()){
            myData.add(scanner.nextLine());
        }

        ArrayList<String[]> boxSeparated = new ArrayList<>();

        int areaTotal = 0;

        for (String dimentions:
             myData) {
            String[] oneBox = new String[3];
            oneBox = dimentions.split("x");
            boxSeparated.add(oneBox);
        }
        int extraPaper = 0;

        for (int i=0; i< boxSeparated.size(); i++){
            String[] oneBox = boxSeparated.get(i);
            int height = Integer.parseInt(oneBox[0]);
            int width = Integer.parseInt(oneBox[1]);
            int length = Integer.parseInt(oneBox[2]);
            int sizeOne = height*width;
            int sizeTwo = width*length;
            int sizeThree = length*height;
            extraPaper = smallestBoxSide(sizeOne, sizeTwo, sizeThree);
            int boxArea = 2*(sizeOne + sizeTwo + sizeThree);
            int wrappingArea = boxArea + extraPaper;
            areaTotal += wrappingArea;
        }
        System.out.println("Total area: " + areaTotal);
    }
}
