package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.Document;
import dsw.repository.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShareAction extends AbstractRudokAction{

    public ShareAction() {
        putValue(SMALL_ICON, loadIcon("imagess/share.png"));
        putValue(NAME, "Share document");
        putValue(SHORT_DESCRIPTION, "Share document");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(!(MainFrame.getInstance().getTree().getSelected() instanceof Document)){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.SELEKT);
            return;
        }

        Document document = (Document)  MainFrame.getInstance().getTree().getSelected();

        String projects[] = MainFrame.getInstance().getNames(document);
        String name = (String) JOptionPane.showInputDialog(null, "Izaberite projekat",
                "Share document", JOptionPane.QUESTION_MESSAGE, null, projects, projects[0]);

        if(name == null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.PRAZAN_STRING);
            return;
        }

        Project project = MainFrame.getInstance().getProjectByName(name);
        MainFrame.getInstance().getTree().shareDocument(document, project);
    }

}
