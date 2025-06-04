import java.util.*;

public class MultiplyCommand extends Command {
    public MultiplyCommand(Calculator calculator, Double number) { super(calculator, number); }
    public void execute() {
        memento = calculator.createMemento();
        calculator.multiply(number);
    }
}