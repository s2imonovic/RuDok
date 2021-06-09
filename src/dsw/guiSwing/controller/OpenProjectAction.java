package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.ProjectView;
import dsw.repository.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProjectAction extends AbstractRudokAction{

    public OpenProjectAction() {
        putValue(SMALL_ICON, loadIcon("imagess/open.png"));
        putValue(NAME, "Open file");
        putValue(SHORT_DESCRIPTION, "Open file");
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());

        if(jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
            try{
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                Project project = null;

                try {
                    project = (Project) os.readObject();
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
                project.setProjectFile(jfc.getSelectedFile());
                MainFrame.getInstance().getTree().addProject(project);

                AppCore.getInstance().getCommand().getCommandManager().getCommands().clear();

                AppCore.getInstance().getSerialization().openProject(project);

            }catch (FileNotFoundException e1){
                e1.printStackTrace();
            }catch (IOException e2){
                e2.printStackTrace();
            }
        }

    }

}


