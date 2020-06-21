package agh.po.lab6;

public class UndoCommand extends Command {

    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        System.out.println(">>> undo <<<");
        this.app.undo();
    }

    @Override
    public String toString() {
        return "Undo operation\n";
    }
}
