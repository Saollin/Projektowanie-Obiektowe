package agh.po.lab6;

public class CutCommand extends Command {

    public CutCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        super.saveBackup();
        this.app.clipboard = this.backup;
        this.editor.deleteSelection();
        System.out.println(">>> cut <<<");
    }

    @Override
    public String toString() {
        return "Cut operation\n";
    }
}
