package CommandPattern;

import java.util.Stack;

public class MacroCommand implements Command{

    // 커맨드 관리
    private Stack<Command> commandStack = new Stack<>();

    @Override
    public void execute() {
        commandStack.forEach(Command::execute);
    }

    public void add(Command command) {
        commandStack.push(command);
    }

    public void undo() {
        commandStack.pop();
    }

    public void clear()
    {
        commandStack.clear();
    }
}
