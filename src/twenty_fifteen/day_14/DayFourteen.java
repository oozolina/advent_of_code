package twenty_fifteen.day_14;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DayFourteen {
    public static void main(String[] args) throws FileNotFoundException {
        ReindeerOlympics reindeerOlympics = new ReindeerOlympics();
        //Part 1
        System.out.println("Winning reindeer traveled " + reindeerOlympics.getTheDistance(2503) + " km.");

        //Part 2
        System.out.println("Winning reindeer have " + reindeerOlympics.getThePoints(2503) + " points.");
    }
}
