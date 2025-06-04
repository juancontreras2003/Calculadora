import java.util.*;

public class DivideCommand extends Command {
    public DivideCommand(Calculator calculator, Double number) { super(calculator, number); }
    public void execute() {
        memento = calculator.createMemento();
        calculator.divide(number);
    }
}
