package agh.po.lab6;

public class PasteCommand extends Command {

    public PasteCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        super.saveBackup();
        this.editor.replaceSelection(this.app.clipboard);
        System.out.println(">>> paste <<<");
    }

    @Override
    public String toString() {
        return "Paste operation\n";
    }
}
