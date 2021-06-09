package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.Project;
import dsw.repository.Workspace;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SaveAction extends AbstractRudokAction{

    public SaveAction() {
        putValue(SMALL_ICON, loadIcon("imagess/save.png"));
        putValue(NAME, "Save");
        putValue(SHORT_DESCRIPTION, "Save");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(MainFrame.getInstance().getTree().getSelected() instanceof Project){
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new ProjectFileFilter());

            Project project = (Project) MainFrame.getInstance().getTree().getSelected();
            File projectFile = project.getProjectFile();

            if(!project.isChanged()){
                return;
            }

            if(project.getProjectFile() == null){
                if(jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
                    projectFile = jfc.getSelectedFile();
                }else{
                    return;
                }
            }

            AppCore.getInstance().getSerialization().saveProject(project, projectFile);
            return;
        }

        AppCore.getInstance().getErrorHandler().generateError(ErrorType.SELEKT);

    }

}
