package twenty_fifteen.day_20;

import java.util.ArrayList;

public class DayTwenty {

    public static void main(String[] args) {
       //Part 1
        // System.out.println(elvesDeliverPresents(100));

        //Part 2
        System.out.println(elvesDeliverMorePresentsToLessHouses(34000000, 50));
    }

    //Part 1
    public static int elvesDeliverPresents(int targetPresents){
        int[] houses = new int[targetPresents/10];
        for (int elf = 1; elf < houses.length; elf++) {
            for (int house = elf; house < houses.length; house+=elf) {
                houses[house] += elf*10;
                // System.out.println("Elf #"+elf+ " visiting house #" + house + " and gives " + elf*10 + " presents. House total for presents is " + houses[house] + ".");
            }
        }
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] >= targetPresents){
                return i;
            }
        }
        return -1;
    }

    //Part 2
    public static int elvesDeliverMorePresentsToLessHouses(int targetPresents, int maxHousesVisited){

        int[] houses = new int[targetPresents/10];
        for (int elf = 1; elf < houses.length; elf++) {
            int housesVisited = 0;
            for (int house = elf; house < houses.length && housesVisited<=maxHousesVisited; house+=elf) {
                houses[house] += elf*11;
                housesVisited++;
                // System.out.println("Elf #"+elf+ " visiting house #" + house + " and gives " + elf*10 + " presents. House total for presents is " + houses[house] + ".");
            }
        }
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] >= targetPresents){
                return i;
            }
        }
        return -1;
    }
}
