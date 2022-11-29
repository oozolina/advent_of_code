package twenty_fifteen.day_18;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DayEighteen {

    public static void main(String[] args) throws IOException {
        var board = generateBoard();
        //   printGrid(board);
        for (int i = 0; i < 100; i++) {
            board = switcher(board);
            //  printGrid(board);
        }
        System.out.println("There are " + howManyLightsAreLitOnTheBoard(board) + " lights lit.");

    }

    public static boolean[][] switcher(boolean[][] currentState) {
        boolean[][] futureState = new boolean[currentState[0].length][currentState.length];
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[0].length; j++) {

                int litNeighbours = litNeighbours(currentState, i, j);
                // Part 2
                if ((i == 0 || i == currentState.length - 1) && (j == 0 || j == currentState.length - 1)) {
                    futureState[i][j] = true;
                } else if (currentState[i][j]) {
                    futureState[i][j] = litNeighbours == 2 || litNeighbours == 3;
                } else {
                    futureState[i][j] = litNeighbours == 3;
                }
            }
        }
        return futureState;
    }

    private static int litNeighbours(boolean[][] currentState, int i, int j) {
        int count = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k != i || l != j) { // equivalent to !(k==i && l==j)
                    if (isLit(currentState, k, l)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean isLit(boolean[][] currentState, int k, int l) {
        if (k == -1 || k >= currentState.length || l == -1 || l >= currentState.length) {
            return false;
        }
        return currentState[k][l];
    }

    public static int howManyLightsAreLitOnTheBoard(boolean[][] currentState) {
        int count = 0;
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState.length; j++) {
                if (currentState[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean[][] generateBoard() throws IOException {
        URL url = DayEighteen.class.getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();

        boolean[][] grid = new boolean[cleanedData.size()][cleanedData.get(0).length()];
        for (int i = 0; i < cleanedData.size(); i++) {
            for (int j = 0; j < cleanedData.get(0).length(); j++) {
                grid[i][j] = (cleanedData.get(i).charAt(j) == '#');
            }
        }
        grid[0][0] = grid[0][grid.length - 1] = grid[grid.length - 1][0] = grid[grid.length - 1][grid.length - 1] = true;
        return grid;
    }

    public static void printGrid(boolean[][] grid) {
        System.out.println("\n=================");
        for (int i = 0; i < grid.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] ? "#" : ".");
            }
        }
        System.out.println("\n=================");
    }
}
