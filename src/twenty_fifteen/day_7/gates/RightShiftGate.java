package twenty_fifteen.day_7.gates;

import twenty_fifteen.day_7.Component;

public class RightShiftGate extends Component {

    private Component source;
    private char delta;
    private char value;
    private boolean dirty = true;

    public RightShiftGate(Component source, char delta) {
        this.source = source;
        this.delta = delta;
    }

    @Override
    public char getValue() {
        if (dirty) {
            value = (char)(source.getValue() >> delta);
            dirty = false;
        }
        return value;
    }
}
