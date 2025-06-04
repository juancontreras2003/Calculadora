import java.util.*;

class ClearCommand extends Command {
    public ClearCommand(Calculator calculator) { super(calculator, null); }
    public void execute() {
        memento = calculator.createMemento();
        calculator.clear();
    }
}