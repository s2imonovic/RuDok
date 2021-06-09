package dsw.serialization;

import dsw.core.Serialization;
import dsw.repository.Document;
import dsw.repository.Page;
import dsw.repository.Project;
import dsw.repository.Workspace;
import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;

import java.io.*;

public class SerializationImpl implements Serialization {

    @Override
    public void openProject(Project project) {

        for(RuNode node : project.getChildren()){
            Document document = (Document) node;
            project.setAkcija("ADD");
            project.notifySubscribers(document);
            for(RuNode node1 : document.getChildren()){
                Page page = (Page) node1;
                document.setAkcija("ADD");
                document.notifySubscribers(page);
                for(RuNode node2 : page.getChildren()){
                    Slot slot = (Slot) node2;
                    page.setAkcija("ADD");
                    page.notifySubscribers(slot);
                }
            }
        }

    }

    @Override
    public void saveProject(Project project, File projectFile) {

        ObjectOutputStream os;

        try{
            os = new ObjectOutputStream(new FileOutputStream(projectFile));
            os.writeObject(project);
            project.setProjectFile(projectFile);
            project.setChanged(false);
        }catch (FileNotFoundException e1){
            e1.printStackTrace();
        }catch (IOException e2){
            e2.printStackTrace();
        }
    }

    @Override
    public void saveWorkspace(Workspace workspace, File workspaceFile) {

        try{
            FileWriter writer = new FileWriter(workspaceFile, false);

            for(RuNode node : workspace.getChildren()){
                Project project = (Project) node;

                if(project.getProjectFile() != null){
                    writer.write(project.getProjectFile().toString());
                }

                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
