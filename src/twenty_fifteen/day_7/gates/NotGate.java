package twenty_fifteen.day_7.gates;

import twenty_fifteen.day_7.Component;

public class NotGate extends Component {

    private Component source;
    private char value;
    private boolean dirty = true;

    public NotGate(Component source) {
        this.source = source;
    }

    @Override
    public char getValue() {
        if (dirty) {
            value = (char) (~source.getValue());
            dirty = true;
        }
        return value;
    }

}
