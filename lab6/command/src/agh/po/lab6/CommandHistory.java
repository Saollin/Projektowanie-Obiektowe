package agh.po.lab6;

import java.util.Stack;

public class CommandHistory {

    private Stack<Command> history;

    public CommandHistory() {
        this.history = new Stack<>();
    }

    public void push(Command command) {
        this.history.push(command);
    }

    public Command pop() {
        if(!this.history.empty()) {
            Command result = this.history.pop();
            while (result.backup == null) {
                result = this.history.pop();
            }
            return result;
        }
        else
            return null;
    }

    public int getSizeOfHistory() {
        return history.size();
    }
}
