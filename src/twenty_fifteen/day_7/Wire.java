package twenty_fifteen.day_7;

public class Wire extends Component{
    private Component source;
    private String name;

    public Wire(String name) {
        this.name = name;
    }

    public void setSource(Component source) {
        this.source = source;
    }

    public Component getSource() {
        return source;
    }

    @Override
    public char getValue() {
        return source.getValue();
    }

//    @Override
//    public String toString() {
//        return "Wire{" +
//                "source=" + source +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
