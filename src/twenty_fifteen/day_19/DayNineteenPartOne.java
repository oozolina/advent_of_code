package twenty_fifteen.day_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DayNineteenPartOne {

    public static void main(String[] args) throws FileNotFoundException {
        String originalMolecule =
                //"HOH";
                "ORnPBPMgArCaCaCaSiThCaCaSiThCaCaPBSiRnFArRnFArCaCaSiThCaCaSiThCaCaCaCaCaCaSiRnFYFArSiRnMgArCaSiRnPTiTiBFYPBFArSiRnCaSiRnTiRnFArSiAlArPTiBPTiRnCaSiAlArCaPTiTiBPMgYFArPTiRnFArSiRnCaCaFArRnCaFArCaSiRnSiRnMgArFYCaSiRnMgArCaCaSiThPRnFArPBCaSiRnMgArCaCaSiThCaSiRnTiMgArFArSiThSiThCaCaSiRnMgArCaCaSiRnFArTiBPTiRnCaSiAlArCaPTiRnFArPBPBCaCaSiThCaPBSiThPRnFArSiThCaSiThCaSiThCaPTiBSiRnFYFArCaCaPRnFArPBCaCaPBSiRnTiRnFArCaPRnFArSiRnCaCaCaSiThCaRnCaFArYCaSiRnFArBCaCaCaSiThFArPBFArCaSiRnFArRnCaCaCaFArSiRnFArTiRnPMgArF";

        ArrayList<String[]> replacements = pullingDataFromFile();
        var allNewMolecules = doReplacement(originalMolecule, replacements);
        System.out.println(countUniqueMolecules(allNewMolecules) + " distinct molecules can be created.");
    }

    public static ArrayList<String> doReplacement(String originalMolecule, ArrayList<String[]> replacements) throws FileNotFoundException {
        ArrayList<String> allNewMolecules = new ArrayList<>();

        for (String[] replacement :
                replacements) {
            int position = 0;
            while ((position = originalMolecule.indexOf(replacement[0], position)) >= 0) {
                String newMolecule = replace(originalMolecule, replacement, position);
                allNewMolecules.add(newMolecule);
                position += replacement[0].length();
            }
        }
        return allNewMolecules;
    }

    public static String replace(String originalMolecule, String[] replacement, int position) {
        return originalMolecule.substring(0, position) + replacement[1] + originalMolecule.substring(position + replacement[0].length());
    }

    public static long countUniqueMolecules(ArrayList<String> molecules) {
        return molecules.stream().distinct().count();
    }

    public static ArrayList<String[]> pullingDataFromFile() throws FileNotFoundException {
        URL url = DayNineteenPartOne.class.getResource("data.txt");
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
