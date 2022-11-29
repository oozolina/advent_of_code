package twenty_fifteen.day_23;

public class Wrapper<T> {
    public Wrapper(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    T value;
}
