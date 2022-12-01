package twenty_twenty_two.day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DayOne {
    public static void main(String[] args) throws FileNotFoundException {
        // Part 1
        System.out.println("How many total Calories is that Elf carrying? " + theMostCaloriesValue(calculateSums(getDataFromFile("data.txt"))));

        //Part 2
        System.out.println("How many Calories are those Elves carrying in total? " + calculateSumOfCaloriesCarryingByTopThree(calculateSums(getDataFromFile("data.txt"))));
    }

    public static int calculateSumOfCaloriesCarryingByTopThree(ArrayList<Integer> snacksCalories){
        int sum = 0;
        Collections.sort(snacksCalories);
        for (int i = snacksCalories.size()-1; i > snacksCalories.size() - 4; i--) {
            sum += snacksCalories.get(i);
        }
        return sum;
    }

    public static int theMostCaloriesValue(ArrayList<Integer> data){
        Collections.sort(data);
        return data.get(data.size()-1);
    }

    public static ArrayList<Integer> calculateSums(ArrayList<ArrayList<String>> data){
        ArrayList<Integer> totalCaloriesByElf = new ArrayList<>();
        for (ArrayList<String> oneElfSupplies: data) {
            int sum = 0;
            for (String calories: oneElfSupplies) {
                sum += Integer.valueOf(calories);
            }
            totalCaloriesByElf.add(sum);
        }
        return totalCaloriesByElf;
    }


    public static ArrayList<ArrayList<String>> getDataFromFile(String path) throws FileNotFoundException {
        URL url = DayOne.class.getResource(path);
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);

        ArrayList<String> myData = new ArrayList<>();
        while(scanner.hasNextLine()){
            myData.add(scanner.nextLine());
        }
        ArrayList<ArrayList<String>> cleanedData = new ArrayList<>();
        for (int i = 0; i < myData.size(); i++) {
            if(myData.get(i).equals("")){
                ArrayList<String> oneElfItems = new ArrayList<>();
                for (int j = i-1; j >= 0; j--) {
                    if(myData.get(j).equals("")){
                        break;
                    }
                    oneElfItems.add(myData.get(j));
                }
                cleanedData.add(oneElfItems);
            }
        }
        return cleanedData;
    }
}
