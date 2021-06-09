package dsw.guiSwing;

import dsw.core.Gui;
import dsw.core.Repository;
import dsw.errorHandler.MyError;
import dsw.guiSwing.view.MainFrame;

public class SwingGui implements Gui {

    private MainFrame mainFrame;
    private Repository documentRepository;

    public SwingGui(Repository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public void start() {
        mainFrame = MainFrame.getInstance();
        mainFrame.setDocumentRepository(documentRepository);
        mainFrame.initialiseWorkSpaceTree();

        mainFrame.setVisible(true);
    }

    @Override
    public void update(Object notification, String akcija) {
        if(notification instanceof MyError){
            MyError error = (MyError) notification;
            MainFrame.getInstance().showError(error);
        }

        if(notification instanceof String){
            String s = (String) notification;
            switch (s){
                case "UNDO-TRUE":
                    MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
                    break;
                case "UNDO-FALSE":
                    MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
                    break;
                case "REDO-TRUE":
                    MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
                    break;
                case "REDO-FALSE":
                    MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
                    break;

            }
        }
    }

}
