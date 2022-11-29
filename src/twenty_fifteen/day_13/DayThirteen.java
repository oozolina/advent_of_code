package twenty_fifteen.day_13;

import java.io.FileNotFoundException;

public class DayThirteen {

    public static void main(String[] args) throws FileNotFoundException {
        GetData firstCase = new GetData();
        System.out.println("Total change in happiness for the optimal seating arrangement that actually includes yourself: " + firstCase.getMaxHappiness());
    }
}
