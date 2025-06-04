import java.util.*;

public class CalculatorInvoker {
    private final Calculator calculator;
    private final Deque<Command> history = new ArrayDeque<>();
    private final Deque<Command> redoStack = new ArrayDeque<>();

    public CalculatorInvoker(Calculator calculator) {
        this.calculator = calculator;
    }
    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
        redoStack.clear();
    }
    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
            redoStack.push(command);
        }
    }
    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            history.push(command);
        }
    }
}
