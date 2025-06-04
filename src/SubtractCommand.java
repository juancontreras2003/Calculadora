import java.util.*;


public class SubtractCommand extends Command {
    public SubtractCommand(Calculator calculator, Double number) { super(calculator, number); }
    public void execute() {
        memento = calculator.createMemento();
        calculator.subtract(number);
    }
}