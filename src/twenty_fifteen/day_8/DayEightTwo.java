package twenty_fifteen.day_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayEightTwo {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> data = pullingDataFromFile("data.txt");
        // Part 2
        int sumOfCharacters = 0;
        for (String string :
                data) {
            sumOfCharacters += string.length();
        }
        ArrayList<String> afterAddingCharacters = new ArrayList<>();
        for (String string :
                data) {
            String cleanString = addingQuotesToBeginningAndEnd(addingBackslashesBeforeQuotes(addDoubleBackslashes(string)));
            afterAddingCharacters.add(cleanString);
        }

        int totalSumInMemory = 0;
        for (String string :
                afterAddingCharacters) {
            totalSumInMemory += string.length();
        }

//        System.out.println("Sum of characters: " + sumOfCharacters);
//        System.out.println("Total sum in memory: " + totalSumInMemory);
        System.out.println("Difference: " + (totalSumInMemory - sumOfCharacters));
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


    //Part 2
    public static String addDoubleBackslashes(String string){
        return string.replaceAll(Pattern.quote("\\"), Matcher.quoteReplacement("\\\\"));
    }

    public static String addingBackslashesBeforeQuotes(String string){
        return string.replaceAll(Pattern.quote("\""), Matcher.quoteReplacement("\\\""));
    }

    public static String addingQuotesToBeginningAndEnd(String string){
        return "\"" + string + "\"";
    }
}
