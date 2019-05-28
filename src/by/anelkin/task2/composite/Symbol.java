package by.anelkin.task2.composite;

public class Symbol implements Component {
    private char value;

    public Symbol(char value) {
        this.value = value;
    }


    @Override
    public boolean add(Component component) {
        return false;
    }

    @Override
    public boolean remove(Component component) {
        return false;
    }



    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return getValue() == symbol.getValue();
    }

    @Override
    public int hashCode() {
        return value;
    }
}
