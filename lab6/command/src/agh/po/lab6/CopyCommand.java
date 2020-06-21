package agh.po.lab6;

public class CopyCommand extends Command {

    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        this.app.clipboard = this.editor.getSelection();
        System.out.println(">>> copy <<<");
    }

    @Override
    public String toString() {
        return "Copy operation\n";
    }
}
