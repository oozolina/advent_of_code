package twenty_fifteen.day_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DaySeven {

    public static void main(String[] args) throws FileNotFoundException {
        //Part 1
        CircuitBuilder circuitBuilder = new CircuitBuilder();
        ArrayList<String> commands = circuitBuilder.pullingDataFromFile();
        circuitBuilder.createCircuit(commands);
        ArrayList<String> commandsTwo = new ArrayList<>();
        circuitBuilder.createCircuit(commandsTwo);
        circuitBuilder.getValueByKey("a");

        // Part 2
        CircuitBuilder partTwo = new CircuitBuilder();
        ArrayList<String> newData = circuitBuilder.pullingDataFromFile();
        partTwo.createCircuit(newData);
        ArrayList<String> newDataTwo = new ArrayList<>();
        newDataTwo.add(   "956 -> b");
        partTwo.createCircuit(newDataTwo);
        partTwo.getValueByKey("a");
    }
}
