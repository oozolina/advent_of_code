package twenty_fifteen.day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DayFiveOne {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> data = pullingDataFromFile("data.txt");

        ArrayList<String> niceStrings = new ArrayList<>();
        for (String string:
                data) {
            if(isWholeStringNice(string)){
                niceStrings.add(string);
            }
        }
        System.out.println("How many strings are nice? " + niceStrings.size());
    }

    public static ArrayList<String> pullingDataFromFile(String path) throws FileNotFoundException {
        URL url = DayFiveOne.class.getResource(path);
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()){
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();
        return cleanedData;
    }

    public static boolean ifStringContainsThreeVowels(String string){
        int sumOfVowels =0;
        char letter;
        for (int i = 0; i < string.length(); i++) {
            letter=string.toLowerCase().charAt(i);
            if(letter=='a' || letter=='e' || letter=='o' || letter=='u' || letter=='i'){
                sumOfVowels +=1;
            }
        }
        if(sumOfVowels >=3){
            return true;
        }
        return false;
    }

    public static boolean ifContainsDoubleLetters(String string){
        for (int i = 0; i < string.length()-1; i++) {
            if(string.charAt(i) == string.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

    public static boolean ifContainsWeirdLettersTogether(String string){
        for (int i = 0; i < string.length(); i++) {
            if(string.contains("ab") || string.contains("cd") || string.contains("pq") || string.contains("xy")){
                return true;
            }
        }
        return false;
    }

    public static boolean isWholeStringNice(String string){
        if(ifStringContainsThreeVowels(string)
                && ifContainsDoubleLetters(string)
                && !ifContainsWeirdLettersTogether(string)){
            return true;
        }
        return false;
    }
}
