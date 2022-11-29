package twenty_fifteen.day_7.gates;

import twenty_fifteen.day_7.Component;

public class OrGate extends Component {

    private Component source1;
    private Component source2;
    private char value;
    private boolean dirty = true;

    public OrGate(Component source1, Component source2) {
        this.source1 = source1;
        this.source2 = source2;
    }

    @Override
    public char getValue() {
        if (dirty) {
            value = (char)(source1.getValue() | source2.getValue());
            dirty = false;
        }
        return value;
    }
}
