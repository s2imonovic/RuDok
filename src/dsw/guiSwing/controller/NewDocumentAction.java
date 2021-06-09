package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.Document;
import dsw.repository.Project;

import java.awt.event.ActionEvent;
import java.util.Random;

public class NewDocumentAction extends AbstractRudokAction{

    public NewDocumentAction() {
        putValue(SMALL_ICON, loadIcon("imagess/docum.png"));
        putValue(NAME, "New Document");
        putValue(SHORT_DESCRIPTION, "New Document");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int label = new Random().nextInt(100);

        Document d = new Document("Document " + label, MainFrame.getInstance().getTree().getSelected());
        if(!(d.getParent() instanceof Project)){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.SELEKT);
            return;
        }
        MainFrame.getInstance().getTree().addDocument(d);
    }

}
