package twenty_fifteen.day_16;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MFCSAM {
    private static List<Sue> allSuesData = new ArrayList<>();
    private static Sue realSue;

    //Part 1
    public void compareSues() throws FileNotFoundException {
        pullDataFromFile();
        createRealSue();

        for (var key :
                realSue.possessions.keySet()) {
            allSuesData = allSuesData.stream()
                    .filter(x -> !x.possessions.containsKey(key)
                            || x.possessions.get(key).equals(realSue.possessions.get(key))).collect(Collectors.toList());

            // same  .filter(x -> (x.possessions.containsKey(key) && x.possessions.get(key).equals(realSue.possessions.get(key))) || !x.possessions.containsKey(key)).collect(Collectors.toList());
        }
        System.out.println("Got your gift: " + allSuesData.get(0).name);

    }

    //Part 2
    public void findRightSue() throws FileNotFoundException {
        pullDataFromFile();
        createRealSue();
        for (var key :
                realSue.possessions.keySet()) {
            if (key.equals("cats:") || key.equals("trees:")) {
                allSuesData = allSuesData.stream()
                        .filter(x -> !x.possessions.containsKey(key)
                                || (x.possessions.get(key) > realSue.possessions.get(key))).collect(Collectors.toList());
            } else if (key.equals("pomeranians:") || key.equals("goldfish:")) {
                allSuesData = allSuesData.stream()
                        .filter(x -> !x.possessions.containsKey(key)
                                || (x.possessions.get(key) < realSue.possessions.get(key))).collect(Collectors.toList());
            } else {
                allSuesData = allSuesData.stream()
                        .filter(x -> !x.possessions.containsKey(key)
                                || x.possessions.get(key).equals(realSue.possessions.get(key))).collect(Collectors.toList());
            }

            // same  .filter(x -> (x.possessions.containsKey(key) && x.possessions.get(key).equals(realSue.possessions.get(key))) || !x.possessions.containsKey(key)).collect(Collectors.toList());
        }
        System.out.println("Real Aunt Sue is " + allSuesData.get(0).name);

    }

    public void createRealSue() {
        Map<String, Integer> map = Stream.of(new Object[][]{
                {"children:", 3},
                {"cats:", 7},
                {"samoyeds:", 2},
                {"pomeranians:", 3},
                {"akitas:", 0},
                {"vizslas:", 0},
                {"goldfish:", 5},
                {"trees:", 3},
                {"cars:", 2},
                {"perfumes:", 1},
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
        HashMap<String, Integer> possessions = new HashMap<String, Integer>(map);
        realSue = new Sue("Real Sue", possessions);
    }

    // Sue 1: goldfish: 9, cars: 0, samoyeds: 9
    public static void pullDataFromFile() throws FileNotFoundException {
        URL url = MFCSAM.class.getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();

        for (String auntInfo :
                cleanedData) {
            // Sue 1: goldfish: 9, cars: 0, samoyeds: 9
            String[] oneAunt = auntInfo.split(" ");
            String name = oneAunt[0] + oneAunt[1];
            HashMap<String, Integer> possessions = new HashMap<>();
            for (int i = 2; i < oneAunt.length; i = i + 2) {
                String num = (oneAunt[i + 1]).substring(0, 1);
                possessions.put(oneAunt[i], Integer.parseInt(num));
            }
            Sue nextAunt = new Sue(name, possessions);
            allSuesData.add(nextAunt);
        }
    }
}
