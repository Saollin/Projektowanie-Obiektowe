package agh.po.lab6;

public abstract class Command {
    protected Application app;
    protected Editor editor;
    protected String backup;

    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
        this.backup = null;
    }

    public void saveBackup() {
        this.backup = this.editor.getSelection();
    }

    public void undo() {
        if(this.backup != null) {
            this.editor.replaceSelection(this.backup);
        }
    }

    abstract public void execute();
}
