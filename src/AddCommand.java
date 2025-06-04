import java.util.*;

public class AddCommand extends Command {
    public AddCommand(Calculator calculator, Double number) { super(calculator, number); }
    public void execute() {
        memento = calculator.createMemento();
        calculator.add(number);
    }
}

