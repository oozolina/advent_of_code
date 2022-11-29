package twenty_fifteen.day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DayFiveTwo {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> data = pullingDataFromFile("data.txt");

        ArrayList<String> niceStrings = new ArrayList<>();
        for (String string:
                data) {
            if(isWholeStringNice(string.toLowerCase())){
                niceStrings.add(string);
            }
        }
        System.out.println("How many strings are nice under these new rules? " + niceStrings.size());
    }

    public static ArrayList<String> pullingDataFromFile(String path) throws FileNotFoundException {
        URL url = DayFiveTwo.class.getResource(path);
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()){
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();
        return cleanedData;
    }

    public static boolean ifContainsPairOFRandomLetters(String string){
        for (int i = 0; i < string.length()-1; i++) {
            for (int j = i+2; j < string.length()-1; j++) {
                if(string.substring(i, i+2).equals(string.substring(j, j+2))){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean ifContainsRepeatLetterWithLetterInBetween(String string){
        for (int i = 0; i < string.length()-2; i++) {
            if(string.charAt(i) == string.charAt(i+2)){
                return true;
            }
        }
        return false;
    }

    public static boolean isWholeStringNice(String string){
        if(ifContainsPairOFRandomLetters(string) && ifContainsRepeatLetterWithLetterInBetween(string)){
            return true;
        }
        return false;
    }
}
