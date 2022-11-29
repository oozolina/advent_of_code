package twenty_fifteen.day_7;

import twenty_fifteen.day_7.Component;

public class Source extends Component {
    private char numericSignal;

    public Source(char numericSignal) {
        this.numericSignal = numericSignal;
    }

    @Override
    public char getValue() {
        return numericSignal;
    }
}
