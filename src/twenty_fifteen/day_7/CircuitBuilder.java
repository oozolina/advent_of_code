package twenty_fifteen.day_7;

import twenty_fifteen.day_7.gates.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CircuitBuilder {

    private HashMap<String, Wire> wires = new HashMap<>();

    public Wire getWire(String name) {
        if(!wires.containsKey(name)){
            wires.put(name, new Wire(name));
        }
        return wires.get(name);
    }

    public void createCircuit(ArrayList<String> commands){
        for (String command:
             commands) {
            String[] newCommand = command.split(" ");

            if(newCommand[1].equals("AND")){
                // 1 AND ht -> hu
                // af AND ah -> ai
                if(newCommand[0].chars().allMatch( Character::isDigit )){
                    int iSource = Integer.valueOf(newCommand[0]);
                    var source = new Source((char)iSource);
                    var andGate = new AndGate(source, getWire(newCommand[2]));
                    var sourceOutput = getWire(newCommand[4]);
                    sourceOutput.setSource(andGate);
                } else {
                    var andGate = new AndGate(getWire(newCommand[0]), getWire(newCommand[2]));
                    var andOutput = getWire(newCommand[4]);
                    andOutput.setSource(andGate);
               }
            } else if (newCommand[1].equals("OR")) {
                //du OR dt -> dv
                var orGate = new OrGate(getWire(newCommand[0]), getWire(newCommand[2]));
                var orOutput = getWire(newCommand[4]);
                orOutput.setSource(orGate);
            } else if (newCommand[1].equals("RSHIFT")) {
                // x RSHIFT 5 -> aa
                int iDelta = Integer.parseInt(newCommand[2]);
                char delta = (char)iDelta;
                var rightShiftGate = new RightShiftGate(getWire(newCommand[0]), delta);
                var rightShiftOutput = getWire(newCommand[4]);
                rightShiftOutput.setSource(rightShiftGate);
            } else if (newCommand[1].equals("LSHIFT")) {
                // an LSHIFT 15 -> ar
                char leftShiftDelta = (char)Integer.parseInt(newCommand[2]);
                var leftShiftGate = new LeftShiftGate(getWire(newCommand[0]), leftShiftDelta);
                var leftShiftOutput = getWire(newCommand[4]);
                leftShiftOutput.setSource(leftShiftGate);
            } else if (newCommand[0].equals("NOT")) {
                // NOT ag -> ah
                var notGate = new NotGate(getWire(newCommand[1]));
                var notGateOutput = getWire(newCommand[3]);
                notGateOutput.setSource(notGate);

            } else if(newCommand.length==3){
                // 123 -> x
                if((newCommand[0].chars().allMatch( Character::isDigit ))){
                    int iSource = Integer.valueOf(newCommand[0]);
                    var source = new Source((char)iSource);
                    var sourceOutput = getWire(newCommand[2]);
                    sourceOutput.setSource(source);
                } else {
                    //lx -> a
                    var straightPass = getWire(newCommand[0]);
                    var output = getWire(newCommand[2]);
                    output.setSource(straightPass);
                }
            }
        }
    }

    public void printWires(){
        for (var entry : wires.entrySet()) {
           System.out.println(entry.getKey() + "/" + (int)(entry.getValue().getValue()));
        }
    }

    public void getValueByKey(String name){
        char value = wires.get(name).getValue();
        System.out.println((int)value);
    }

    public void findWiresSize(){
        System.out.println(wires.size());
    }


    public ArrayList<String> pullingDataFromFile() throws FileNotFoundException {
        URL url = getClass().getResource("data.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        ArrayList<String> cleanedData = new ArrayList<>();
        while (scanner.hasNextLine()){
            cleanedData.add(scanner.nextLine());
        }
        scanner.close();
        return cleanedData;
    }
}
