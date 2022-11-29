package twenty_fifteen.day_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class GetData {

    private HashMap<String, Integer> levelOfHappiness = new HashMap<>();
    private Set<String> guestsNames = new HashSet<>();

    // Part 1
    public int getMaxHappiness() throws FileNotFoundException {
        pullDataFromFile();
        var guestNamesTwo = new ArrayList<>(guestsNames);
        guestNamesTwo.remove("Alice");
        // Part 2
        guestNamesTwo.add("Olga");

        // need to start and finish with Alice, use her data but exclude from the list for tree
        Guest alice = new Guest("Alice", null, guestNamesTwo, levelOfHappiness);
        List<Integer> finalHappiness = alice.getTotalHappiness();
        Collections.sort(finalHappiness);
        return finalHappiness.get(finalHappiness.size() - 1);
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

        for (String fact:
             cleanedData) {
            //Alice would gain 54 happiness units by sitting next to Bob.
            //Alice would lose 79 happiness units by sitting next to Carol.
            String[] oneLineData = fact.split(" ");
            if(oneLineData[2].equals("lose")){
                oneLineData[3] = "-"+oneLineData[3];
            }
            levelOfHappiness.put(oneLineData[0] + " next to " + oneLineData[10], Integer.parseInt(oneLineData[3]));

            guestsNames.add(oneLineData[0]);
        }
    }
}
