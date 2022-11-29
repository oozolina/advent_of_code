package twenty_fifteen.day_23;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DayTwentyThree {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getBValue(getCommands(getData())));
        System.out.println(getBValueAccordingAbram(getCommands(getData())));
    }

    // initial variant
    public static int getBValue(ArrayList<String[]> commands) {
        //Part 1
        int registerA = 0;
        //Part 2
        // int registerA = 1;
        int registerB = 0;
        int value = 0;

        for (int i = 0; i < commands.size(); ) {
            var command = commands.get(i);
            if (command[1].equals("a")) {
                value = registerA;
            } else {
                value = registerB;
            }
            switch (command[0]) {
                case "hlf":
                    value = value / 2;
                    i++;
                    break;
                case "tpl":
                    value = value * 3;
                    i++;
                    break;
                case "inc":
                    value++;
                    i++;
                    break;
                case "jmp":
                    if (command[1].startsWith("+")) {
                        i = i + Integer.valueOf(command[1].substring(1));

                        break;
                    }
                    i -= Integer.valueOf(command[1].substring(1));
                    break;
                case "jie":
                    if (value % 2 == 0) {
                        if (command[2].startsWith("+")) {
                            i += Integer.valueOf(command[2].substring(1));
                            break;
                        }
                        i -= Integer.valueOf(command[2].substring(1));
                        break;
                    }
                    i++;
                    break;
                case "jio":
                    if (value == 1) {
                        if (command[2].startsWith("+")) {
                            i += Integer.valueOf(command[2].substring(1));
                            break;
                        }
                        i -= Integer.valueOf(command[2].substring(1));
                        break;
                    }
                    i++;
                    break;
            }
            if (command[1].equals("a")) {
                registerA = value;
            } else {
                registerB = value;
            }

        }

        System.out.println(registerA);
        return registerB;
    }

    // After series of refactoring
    public static int getBValueAccordingAbram(ArrayList<String[]> commands) {
        //Part 1
        Wrapper<Integer> registerA = new Wrapper<>(0);
        //Part 2
        //Wrapper<Integer> registerA = new Wrapper<>(1);
        Wrapper<Integer> registerB = new Wrapper<>(0);

        for (var i = 0; i < commands.size(); i++) {

            var command = commands.get(i);
            if (command[1].equals("a")) {
                i += processCommand(registerA, command);
            } else {
                i += processCommand(registerB, command);
            }
        }
        System.out.println(registerA.getValue());
        return registerB.getValue();
    }

    private static int processCommand(Wrapper<Integer> register, String[] command) {
        switch (command[0]) {
            case "hlf":
                register.setValue(register.getValue() / 2);
                return 0;
            case "tpl":
                register.setValue(register.getValue() * 3);
                return 0;
            case "inc":
                register.setValue(register.getValue() + 1);
                return 0;
            case "jmp":
                return Integer.valueOf(command[1]) - 1;
            case "jie":
                if (register.getValue() % 2 == 0) {
                    return Integer.valueOf(command[2]) - 1;
                }
                break;
            case "jio":
                if (register.getValue() == 1) {
                    return Integer.valueOf(command[2]) - 1;
                }
                break;
        }
        return 0;
    }

    public static ArrayList<String[]> getCommands(ArrayList<String> data) {
        ArrayList<String[]> commands = new ArrayList<>();
        for (String command :
                data) {
            String[] instruction = command.replaceAll(",", "").split(" ");
            commands.add(instruction);
        }
        return commands;
    }

    public static ArrayList<String> getData() throws FileNotFoundException {
        URL url = DayTwentyThree.class.getResource("data.txt");
        File file = new File(url.getPath());

        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();
        return cleanedData;
    }
}
