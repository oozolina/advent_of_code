package twenty_fifteen.day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DaySixTwo {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> data = pullingDataFromFile("data.txt");
        ArrayList<String[]> usefulData = separateCommand(data);

        int[][] myLights = generateBoard(1000);
        makeSmthWithLigths(myLights, usefulData);

        System.out.println("Total brightness of all lights combined after Santa's instructions: " + getTotalBrightness(myLights));
    }

    public static ArrayList<String> pullingDataFromFile(String path) throws FileNotFoundException {
        URL url = DaySixTwo.class.getResource(path);
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();
        return cleanedData;
    }

    public static ArrayList<String[]> separateCommand(ArrayList<String> data) {
        ArrayList<String[]> commands = new ArrayList<>();
        for (String command :
                data) {
            String[] oneCommand = new String[6];
            String firstCommand = getFirstCommand(command);
            oneCommand[0] = firstCommand;
            String formattedCommand = command.replace(firstCommand, "");
            String[] cutCommand = formattedCommand.split(" ");
            String[] firstCoordinates = cutCommand[0].split(",");
            oneCommand[1] = firstCoordinates[0];
            oneCommand[2] = firstCoordinates[1];
            String[] secondCoordinates = cutCommand[2].split(",");
            oneCommand[3] = cutCommand[1];
            oneCommand[4] = secondCoordinates[0];
            oneCommand[5] = secondCoordinates[1];
            commands.add(oneCommand);
        }
        return commands;
    }

    public static String getFirstCommand(String oneCommand) {
        return oneCommand.split("[0-9]")[0];
    }

    // redundant, because when initializing [][] default values are 0
    public static int[][] generateBoard(int size) {
        int[][] grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = 0;
            }
        }
        return grid;
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]);
            }
        }
    }

    public static int[][] makeSmthWithLigths(int[][] grid, ArrayList<String[]> commands) {
        for (String[] command :
                commands) {
            String action = command[0];
            int firstX = Integer.parseInt(command[1]);
            int secondX = Integer.parseInt(command[4]);
            int firstY = Integer.parseInt(command[2]);
            int secondY = Integer.parseInt(command[5]);
            //    System.out.println(action + " X: from " + firstX + " to " + secondX + " Y: from " + firstY + " to " + secondY);
            for (int i = firstX; i <= secondX; i++) {
                for (int j = firstY; j <= secondY; j++) {
                    switch (action) {
                        case "turn on ":
                            grid[j][i] += 1;
                            break;
                        case "turn off ":
                            grid[j][i] -= 1;
                            if (grid[j][i] < 0) {
                                grid[j][i] = 0;
                            }
                            break;
                        case "toggle ":
                            grid[j][i] += 2;
                            break;
                    }
                }
            }
        }
        return grid;
    }

    public static int getTotalBrightness(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum = sum + grid[i][j];
            }
        }
        return sum;
    }
}
