import java.util.*;

public abstract class Command {
    protected Calculator calculator;
    protected Double number;
    protected Memento memento;
    public Command(Calculator calculator, Double number) {
        this.calculator = calculator;
        this.number = number;
    }
    public abstract void execute();
    public void undo() {
        if (memento != null) {
            calculator.restoreMemento(memento);
        }
    }
}