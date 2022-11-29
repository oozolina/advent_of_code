package twenty_fifteen.day_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayEightOne {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> data = pullingDataFromFile("data.txt");

        // Part 1
        int sumOfCharacters = 0;
        for (String string:
                data) {
            sumOfCharacters += string.length();
        }
        ArrayList<String> afterRemovingCharacters = new ArrayList<>();
        for (String string:
                data) {
            String cleanString = removeBackslashBeforeQuate(removeBackslashes(removingQuotes(takingOffHex(string))));
            afterRemovingCharacters.add(cleanString);
        }

        int totalSumInMemory = 0;
        for (String string:
                afterRemovingCharacters) {
            totalSumInMemory += string.length();
        }

//        System.out.println("Sum of characters: " + sumOfCharacters);
//        System.out.println("Total sum in memory: " + totalSumInMemory);
        System.out.println("Difference: " + (sumOfCharacters - totalSumInMemory));

    }

    public static ArrayList<String> pullingDataFromFile(String path) throws FileNotFoundException {
        URL url = DayEightOne.class.getResource(path);
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()){
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();
        return cleanedData;
    }

    // Part 1
    public static String takingOffHex(String string){
        StringBuffer stringBuffer = new StringBuffer();
        // this pattern didn't work
      //  Pattern pattern = Pattern.compile("\\\\x[0-9A-F]{2}+");
        Pattern pattern = Pattern.compile("\\\\[xX][0-9a-fA-F]{2}+");
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()){
            matcher.appendReplacement(stringBuffer, "U");   // replace hex with String since I don't care what char it would be
        }
        matcher.appendTail(stringBuffer);
        String afterAscii = stringBuffer.toString();

        return afterAscii;
    }

    public static String removingQuotes(String string){
        return string.substring(1, string.length() - 1);
    }

    public static String removeBackslashes(String string){
        return string.replaceAll(Pattern.quote("\\\\"), Matcher.quoteReplacement("0"));
    }

    public static String removeBackslashBeforeQuate(String string){
        return string.replaceAll(Pattern.quote("\\\""), Matcher.quoteReplacement("8"));
    }
}
