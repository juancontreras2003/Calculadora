import java.util.*;

public class Calculator {
    private double value = 0;
    public Memento createMemento() {
        return new Memento(value);
    }
    public void restoreMemento(Memento memento) {
        value = memento.getState();
    }
    public void add(double number) {
        value += number;
    }
    public void subtract(double number) {
        value -= number;
    }
    public void multiply(double number) {
        value *= number;
    }
    public void divide(double number) {
        if (number != 0) {
            value /= number;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    }
    public void clear() {
        value = 0;
    }
    public double getValue() {
        return value;
    }
    @Override
    public String toString() {
        return Double.toString(value);
    }
}