package twenty_fifteen.day_12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DayTwelve {

    public static void main(String[] args) throws IOException {

        String data = Files.readString(Paths.get(".\\src\\twenty_fifteen\\day_12\\data.txt"));

        //Part 1
        System.out.println("Sum of all numbers in the document: " + sumOfNumbers(data));

        //Part 2
        String partTwo = removeObjectsWithRed(data);
        System.out.println("Sum of all numbers in the document without 'red' objects: " + sumOfNumbers(partTwo));
    }


    //Part 1
    public static int sumOfNumbers(String data) throws IOException {
        data = data.replaceAll("[a-zA-Z{}\\[\\],:\"]+", " ");
        String[] cleanedData = data.split("\\s");
        int sum = 0;
        for (String number: cleanedData) {
            if(!number.equals("")) {
                int num = Integer.parseInt(number);
                sum += num;
            }
        }
        return sum;
    }

    //Part 2
    public static String removeObjectsWithRed(String data) {

        while (data.indexOf("\":\"red\"") > 0) {
            int leftCursor = data.indexOf("\":\"red\"");
            int rightCursor = leftCursor + 6;

            for (int openSets = 1; openSets > 0; leftCursor--) {
                char symbol = data.charAt(leftCursor);
                if (symbol == '{') {
                    openSets--;
                }
                if (symbol == '}') {
                    openSets++;
                }
            }

            for (int openSets = 1; openSets > 0; rightCursor++) {
                char symbol = data.charAt(rightCursor);
                if (symbol == '}') {
                    openSets--;
                }
                if (symbol == '{') {
                    openSets++;
                }
            }
            data = data.substring(0, leftCursor) + data.substring(rightCursor);
        }
        return data;
    }
}
