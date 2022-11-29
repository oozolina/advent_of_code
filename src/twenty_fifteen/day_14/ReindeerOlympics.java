package twenty_fifteen.day_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReindeerOlympics {

    private ArrayList<Reindeer> reindeers = new ArrayList<>();
    private ArrayList<Integer> distancesOfAllDeers = new ArrayList<>();

    // Part 1
    public int getTheDistance(int seconds) throws FileNotFoundException {
        //Vixen can fly 19 km/s for 7 seconds, but then must rest for 124 seconds.
        pullDataFromFile();

        for (Reindeer reindeer :
                reindeers) {
            reindeer.step(seconds);
        }

        int maxDistance = 0;
        for (Reindeer reindeer :
                reindeers) {
            maxDistance = Math.max(maxDistance, reindeer.getTotalDistance());
        }
        return maxDistance;

    }

    // Part 2
    public int getThePoints(int seconds) throws FileNotFoundException {
        //Vixen can fly 19 km/s for 7 seconds, but then must rest for 124 seconds.
        pullDataFromFile();
        int maxCurrentDistance = 0;
        int maxPoints = 0;

        for (int i = 0; i < seconds; i++) {
            for (Reindeer reindeer :
                    reindeers) {
                reindeer.step();
                maxCurrentDistance = Math.max(maxCurrentDistance, reindeer.getTotalDistance());
            }
            for (Reindeer reindeer :
                    reindeers) {
                if (reindeer.getTotalDistance() == maxCurrentDistance) {
                    reindeer.addPoint();
                    maxPoints = Math.max(maxPoints, reindeer.getPoints());
                }
            }
        }
        return maxPoints;
    }

    void pullDataFromFile() throws FileNotFoundException {
        URL url = getClass().getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();
        reindeers.clear();
        for (String description :
                cleanedData) {
            String[] data = description.split(" ");
            //Vixen can fly 19 km/s for 7 seconds, but then must rest for 124 seconds.
            Reindeer reindeer = new Reindeer(data[0], Integer.parseInt(data[3]), Integer.parseInt(data[6]), Integer.parseInt(data[13]));
            reindeers.add(reindeer);
        }
    }
}
