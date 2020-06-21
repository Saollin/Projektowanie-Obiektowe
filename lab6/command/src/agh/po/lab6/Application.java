package agh.po.lab6;

import java.util.ArrayList;

public class Application {
    public ArrayList<Editor> editors;
    public Editor activeEditor;
    public String clipboard;
    public CommandHistory history;

    public Application(Editor startEditor, String startClipboard) {
        this.editors = new ArrayList<>();
        addEditor(startEditor);
        this.activeEditor = startEditor;
        this.clipboard = startClipboard;
        this.history = new CommandHistory();
    }

    public void addEditor(Editor editor) {
        this.editors.add(editor);
    }

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void displayState() {
        System.out.println("----------------------------------------------------");
        System.out.println("Current state:" );
        int index = 0;
        for(Editor e : editors) {
            if(e == activeEditor) {
                System.out.printf("\nEditor %d (active) - content: \n\t%s\n", index++, e.getSelection());
            }
            else {
                System.out.printf("\nEditor %d - content: \n\t%s\n", index++, e.getSelection());
            }
        }
        System.out.printf("\nClipboard: \n%s\n", clipboard);
        System.out.println("----------------------------------------------------");
    }

    public void undo() {
        Command tmp = history.pop();
        if(tmp != null) {
            tmp.undo();
        }
        else {
            System.out.println("Operation can't be undone.");
        }
    }
}
