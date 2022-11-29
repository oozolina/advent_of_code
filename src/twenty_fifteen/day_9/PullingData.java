package twenty_fifteen.day_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class PullingData {

    private HashMap<String, Integer> distances = new HashMap();
    private Set<String> cityNames = new HashSet<>();

    // Part 1
    public int getMinimumDistance() throws FileNotFoundException {
        pullDataFromFile();
        var cityNames2 = new ArrayList<String>(cityNames);
        TripSegment santaWorkshop = new TripSegment("Santa's Workshop", null, cityNames2, distances);
        List<Integer> finalDistances = santaWorkshop.getTotalDistance();
        Collections.sort(finalDistances);
        return finalDistances.get(0);
    }

    // Part 2
    public int getMaximumDistance() throws FileNotFoundException {
        pullDataFromFile();
        var cityNames2 = new ArrayList<String>(cityNames);
        TripSegment santaWorkshop = new TripSegment("Santa's Workshop", null, cityNames2, distances);
        List<Integer> finalDistances = santaWorkshop.getTotalDistance();
        Collections.sort(finalDistances);
        return finalDistances.get(finalDistances.size()-1);
    }

    private void pullDataFromFile() throws FileNotFoundException {
        URL url = getClass().getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()){
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();

        for (String route:
                cleanedData) {
            // London to Dublin = 464
            String[] kvp = route.split(" = ");
            distances.put(kvp[0], Integer.parseInt(kvp[1]));

            String[] cities =  kvp[0].split(" to ");
            distances.put(cities[1] + " to " + cities[0], Integer.parseInt(kvp[1]));
            cityNames.add(cities[0]);
            cityNames.add(cities[1]);
        }
    }
}
