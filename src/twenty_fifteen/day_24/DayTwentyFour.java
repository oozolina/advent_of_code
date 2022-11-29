package twenty_fifteen.day_24;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class DayTwentyFour {

    public static void main(String[] args) throws FileNotFoundException {
        var data = getData();

        //Part 1
        int targetWeight = data.stream().mapToInt(Integer::intValue).sum() / 3;
        //Part 2
        //int targetWeight = data.stream().mapToInt(Integer::intValue).sum() / 4;

        var allValidCombinations = findPossibleCombinations(targetWeight, data);
        var found = allValidCombinations.stream().sorted(new QeComparator()).findFirst().get();
        System.out.println("What is the quantum entanglement of the first group of packages in the ideal configuration? " + calculateQuantumEntanglement(found));
    }

    private static class QeComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            return Long.compare(calculateQuantumEntanglement(o1), calculateQuantumEntanglement(o2));
        }
    }

    public static ArrayList<ArrayList<Integer>> findPossibleCombinations(int desiredWeight, ArrayList<Integer> data) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        ArrayList<ArrayList<Integer>> validCombinations = new ArrayList<>();
        combinations.add(new ArrayList<>());

        int minBoxes = Integer.MAX_VALUE;

        for (int i = 0; i <= data.size(); i++) {
            if(i==data.size()-1){
                int j = 0;
            }
            var temp = (ArrayList<ArrayList<Integer>>)combinations.clone();
            combinations.clear();
            for (var list: temp) {
                if(getSum(list)==desiredWeight && list.size()<=minBoxes) {
                    validCombinations.add(list);
                    minBoxes = list.size();
                 //   System.out.println(list);
                } else if (getSum(list)>=desiredWeight || list.size()>=minBoxes){
                    continue; //discard that list
                } else if(i< data.size()) {
                    combinations.add(list);
                    var newList = (ArrayList<Integer>)list.clone();
                    newList.add(data.get(i));
                    combinations.add(newList);
                }
            }
        }
        return validCombinations;
    }

    public static long calculateQuantumEntanglement(ArrayList<Integer> singleCombination) {
        long quantumEntanglement = 1;
        for (Integer box :
                singleCombination) {
            quantumEntanglement *= box;
        }
        return quantumEntanglement;
    }

    public static void print(ArrayList<ArrayList<Integer>> commands) {
        for (ArrayList<Integer> box :
                commands) {
            System.out.println(box);
        }
    }

    public static int getSum(ArrayList<Integer> data) {
        int sum = 0;
        for (Integer number :
                data) {
            sum += number;
        }
        return sum;
    }

    public static ArrayList<Integer> getData() throws FileNotFoundException {
        URL url = DayTwentyFour.class.getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cleanedData.add(Integer.valueOf(scanner.nextLine()));
        }
        scanner.close();
        Collections.sort(cleanedData);
        Collections.reverse(cleanedData);
        return cleanedData;
    }
}
