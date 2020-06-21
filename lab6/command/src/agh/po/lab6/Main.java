package agh.po.lab6;

public class Main {

    public static void main(String[] args) {

        Editor editor1 = new Editor();
        Editor editor2 = new Editor();
        Editor editor3 = new Editor();
        editor1.replaceSelection("Value 1");
        editor2.replaceSelection("Value 2");
        editor3.replaceSelection("Value 3");

        Application app = new Application(editor1, "");
        app.addEditor(editor2);
        app.addEditor(editor3);
        app.displayState();

        app.executeCommand(new CutCommand(app, editor1));
        app.executeCommand(new PasteCommand(app, editor2));
        app.displayState();

        app.executeCommand(new CopyCommand(app, editor2));
        app.executeCommand(new PasteCommand(app, editor1));
        app.executeCommand(new PasteCommand(app, editor3));
        app.displayState();

        app.executeCommand(new UndoCommand(app, editor3));
        app.displayState();

        System.out.printf("\nNumber of done operations: %d\n", app.history.getSizeOfHistory()); // 5
    }
}
