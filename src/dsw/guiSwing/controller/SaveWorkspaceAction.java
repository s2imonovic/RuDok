package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.Workspace;

import javax.swing.*;
import java.io.File;

public class SaveWorkspaceAction {

    public void action() {

        Workspace workspace = MainFrame.getInstance().getDocumentRepository().getWorkspace();

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new WorkspaceFileFilter());

        File workspaceFile = workspace.getWorkspaceFile();

        if(workspace.getWorkspaceFile() == null){
            if(jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
                workspaceFile = jfc.getSelectedFile();
            }else{
                return;
            }
        }

        AppCore.getInstance().getSerialization().saveWorkspace(workspace, workspaceFile);

    }

}
