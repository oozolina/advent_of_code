package twenty_fifteen.day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DayThree {

    public static void main(String[] args) throws IOException {
        String rawData = Files.readString(Paths.get(".\\src\\twenty_fifteen\\day_3\\data.txt"));
        String[] splitData = rawData.split("");
        ArrayList<String> usefulData = new ArrayList<>(Arrays.asList(splitData));

        //Part 1.
        ArrayList<int[]> uniqueHomesVisited = removeDuplicatesHomes(getVisitedHomesCoordinates(usefulData));
        removeDuplicatesHomes(uniqueHomesVisited);
        removeDuplicatesHomes(uniqueHomesVisited);
        System.out.println("How many houses receive at least one present for part 1? " + uniqueHomesVisited.size());

        //Part 2.
        ArrayList<String> santaDirections = getSantaDirections(usefulData);
        ArrayList<String> roboSantaDirections = getRoboDirections(usefulData);

        ArrayList<int[]> santaCoordinates = getVisitedHomesCoordinates(santaDirections);
        ArrayList<int[]> roboCoordinates = getVisitedHomesCoordinates(roboSantaDirections);

        ArrayList<int[]> allVisitedHomes = new ArrayList<>();
        allVisitedHomes.addAll(santaCoordinates);
        allVisitedHomes.addAll(roboCoordinates);

        // no clue why it doesn't remove duplicates at the first time
        removeDuplicatesHomes(allVisitedHomes);
        System.out.println("Part 2. How many houses receive at least one present? " + allVisitedHomes.size());
        removeDuplicatesHomes(allVisitedHomes);
        System.out.println("Part 2. How many houses receive at least one present? " + allVisitedHomes.size());
        removeDuplicatesHomes(allVisitedHomes);
        System.out.println("Part 2. How many houses receive at least one present? " + allVisitedHomes.size());
        removeDuplicatesHomes(allVisitedHomes);
        System.out.println("Part 2. How many houses receive at least one present? " + allVisitedHomes.size());
    }

    // creating a "travel log"(set of coordinates) of visited homes
    public static ArrayList<int[]> getVisitedHomesCoordinates(ArrayList<String> directions){
        ArrayList<int[]> visitedHomes = new ArrayList<>();
        int[] firstCell = {0,0};
        visitedHomes.add(firstCell);
        int[] currentHome = firstCell;
        for (int i=0; i<directions.size(); i++){
            int[] nextHome = new int[2];
            if(directions.get(i).equals(">")){ // going right, +1 to x
                nextHome[0]=currentHome[0]+1;
                nextHome[1]=currentHome[1];
                visitedHomes.add(nextHome);
            } if(directions.get(i).equals("<")){// going left, -1 to x
                nextHome[0]=currentHome[0]-1;
                nextHome[1]=currentHome[1];
                visitedHomes.add(nextHome);
            } if(directions.get(i).equals("^")){// going up, +1 to y
                nextHome[1]=currentHome[1]+1;
                nextHome[0]=currentHome[0];
                visitedHomes.add(nextHome);
            } if(directions.get(i).equals("v")){// going down, -1 to y
                nextHome[1]=currentHome[1]-1;
                nextHome[0]=currentHome[0];
                visitedHomes.add(nextHome);
            }
            currentHome = nextHome;
        }
        return visitedHomes;
    }

    public static ArrayList<int[]> removeDuplicatesHomes(ArrayList<int[]> visitedHomesCoordinated) {
        for (int i = 0; i < visitedHomesCoordinated.size(); i++) {
            int[] firstArr = visitedHomesCoordinated.get(i);
            for (int j = i+1; j < visitedHomesCoordinated.size(); j++) {
                int[] arr = visitedHomesCoordinated.get(j);
                if(Arrays.equals(firstArr, arr)){
                    visitedHomesCoordinated.remove(j);
                }
            }
        }
        return visitedHomesCoordinated;
    }

    public static ArrayList<String> getSantaDirections(ArrayList<String> data){
        ArrayList<String> newDirections = new ArrayList<>();
        int tempValue = 0;
        for (String direction:
             data) {
            if(tempValue%2 == 0){
                newDirections.add(direction);
            }
            tempValue++;
        }
        return newDirections;
    }

    public static ArrayList<String> getRoboDirections(ArrayList<String> data){
        ArrayList<String> newDirections = new ArrayList<>();
        int tempValue = 0;
        for (String direction:
                data) {
            if(tempValue%2 != 0){
                newDirections.add(direction);
            }
            tempValue++;
        }
        return newDirections;
    }
}
