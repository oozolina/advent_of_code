package twenty_fifteen.day_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class DayNineteenPartTwo {

    public static void main(String[] args) throws FileNotFoundException {
        String originalMolecule =
                //  "HOHOHO";
                "ORnPBPMgArCaCaCaSiThCaCaSiThCaCaPBSiRnFArRnFArCaCaSiThCaCaSiThCaCaCaCaCaCaSiRnFYFArSiRnMgArCaSiRnPTiTiBFYPBFArSiRnCaSiRnTiRnFArSiAlArPTiBPTiRnCaSiAlArCaPTiTiBPMgYFArPTiRnFArSiRnCaCaFArRnCaFArCaSiRnSiRnMgArFYCaSiRnMgArCaCaSiThPRnFArPBCaSiRnMgArCaCaSiThCaSiRnTiMgArFArSiThSiThCaCaSiRnMgArCaCaSiRnFArTiBPTiRnCaSiAlArCaPTiRnFArPBPBCaCaSiThCaPBSiThPRnFArSiThCaSiThCaSiThCaPTiBSiRnFYFArCaCaPRnFArPBCaCaPBSiRnTiRnFArCaPRnFArSiRnCaCaCaSiThCaRnCaFArYCaSiRnFArBCaCaCaSiThFArPBFArCaSiRnFArRnCaCaCaFArSiRnFArTiRnPMgArF";
        ArrayList<String[]> replacements = pullingDataFromFile();
        System.out.println("Fewest number of steps to go from 'e' to the given molecule: " + makeTheMolecule(originalMolecule, replacements));
    }

    public static int makeTheMolecule(String molecule, ArrayList<String[]> replacements) {
        ArrayList<Integer> listOfSteps = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int steps = 0;
            String finalMolecule = molecule;
            while (!finalMolecule.equals("e")) {
                ArrayList<String[]> temp = new ArrayList<>();

                for (String[] replacement : replacements) {
                    if (finalMolecule.contains(replacement[1])) {
                        temp.add(replacement);
                    }
                }
                if (temp.size() == 0) {
                    break;
                }
                String[] randomReplacement = temp.get(random.nextInt(temp.size()));

                int position = 0;
                ArrayList<Integer> positions = new ArrayList<>();

                while ((position = finalMolecule.indexOf(randomReplacement[1], position)) >= 0) {
                    positions.add(position);
                    position += randomReplacement[1].length();
                }

                int positionToUse = positions.get(random.nextInt(positions.size()));

                finalMolecule = replace(finalMolecule, randomReplacement, positionToUse);

                steps++;
            }
            if (finalMolecule.equals("e")) {
                listOfSteps.add(steps);
            }
        }
        return Collections.min(listOfSteps);
    }

    public static String replace(String originalMolecule, String[] replacement, int position) {
        return originalMolecule.substring(0, position) + replacement[0] + originalMolecule.substring(position + replacement[1].length());
    }

    public static ArrayList<String[]> pullingDataFromFile() throws FileNotFoundException {
        URL url = DayNineteenPartTwo.class.getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();

        ArrayList<String[]> commands = new ArrayList<>();
        for (String command :
                cleanedData) {
            String[] replacement = command.split(" => ");
            commands.add(replacement);
        }
        return commands;
    }
}
