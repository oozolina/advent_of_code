package twenty_fifteen.day_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class DaySeventeen {
    public static void main(String[] args) throws FileNotFoundException {
        //pullDataFromFile();
        //Part 1
        System.out.println(findPossibleContainersCombinations(150, pullDataFromFile()) + " combinations of containers can exactly fit all 150 liters of eggnog.");

        // Part 2
        System.out.println(findNumberOfMinContainerCombinations(150, pullDataFromFile()) + " different ways can you fill that number of containers and still hold exactly 150 litres.");
    }

    // Part 1
    public static int findPossibleContainersCombinations(int amountOfLitersToStore, ArrayList<Integer> data){
        int count = 0;

        for (int i = 0; i < Math.pow(2, data.size())-1; i++) {
            var x = Integer.toBinaryString(i);
            while (x.length()< data.size()){
                x = "0"+ x;
            }
            int total = 0;
            for (int j = 0; j < x.length(); j++) {
                if(x.charAt(j) == '1'){
                    total += data.get(j);
                }
            }
            if(total==amountOfLitersToStore){
                count++;
            }
        }
        return count;
    }

    // Part 2
    public static int findNumberOfMinContainerCombinations(int amountOfLitersToStore, ArrayList<Integer> data){
        int count = 0;
        List<Integer> containers = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, data.size())-1; i++) {
            var x = Integer.toBinaryString(i);
            while (x.length()< data.size()){
                x = "0"+ x;
            }
            int total = 0;
            int numberOfContainers = 0;
            for (int j = 0; j < x.length(); j++) {
                if(x.charAt(j) == '1'){
                    total += data.get(j);
                    numberOfContainers++;
                }
            }
            if(total==amountOfLitersToStore){
                count++;
                containers.add(numberOfContainers);
            }
        }

        containers.sort(Comparator.naturalOrder());
        int lowestNumber = containers.get(0);
        long lowestNumberCount = containers.stream().filter(x -> x == lowestNumber).count();

        return (int)lowestNumberCount;
    }

    public static ArrayList<Integer> pullDataFromFile() throws FileNotFoundException {
        URL url = DaySeventeen.class.getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> cleanedData = new ArrayList<>();
        while (scanner.hasNextInt()) {
            cleanedData.add(scanner.nextInt());
        }
        scanner.close();
        return cleanedData;
    }
}
