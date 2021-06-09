package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.Project;
import dsw.repository.Workspace;
import dsw.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class SwitchWorkspace extends AbstractRudokAction {

    public SwitchWorkspace() {
        putValue(SMALL_ICON, loadIcon("imagess/switch.png"));
        putValue(NAME, "Switch");
        putValue(SHORT_DESCRIPTION, "Switch");
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new WorkspaceFileFilter());

        if(jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
            try{
                File file = jfc.getSelectedFile();

                Workspace workspace = MainFrame.getInstance().getDocumentRepository().getWorkspace();
                workspace.getChildren().clear();

                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    ObjectInputStream os = new ObjectInputStream(new FileInputStream(new File(data)));

                    Project project = null;

                    try {
                        project = (Project) os.readObject();
                    }catch (ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    project.setProjectFile(jfc.getSelectedFile());
                    MainFrame.getInstance().getTree().addProject(project);

                    AppCore.getInstance().getSerialization().openProject(project);
                }

                myReader.close();

            }catch (FileNotFoundException e1){
                e1.printStackTrace();
            }catch (IOException e2){
                e2.printStackTrace();
            }
        }
    }

}
