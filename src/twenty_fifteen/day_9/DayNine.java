package twenty_fifteen.day_9;

import java.io.FileNotFoundException;

public class DayNine {

    public static void main(String[] args) throws FileNotFoundException {
        PullingData pullingData = new PullingData();
        System.out.println("The distance of the shortest route: " + pullingData.getMinimumDistance());
        System.out.println("The distance of the longest route: " + pullingData.getMaximumDistance());
    }
}
