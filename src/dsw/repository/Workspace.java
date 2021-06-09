package dsw.repository;

import dsw.repository.node.RuNode;
import dsw.repository.node.RuNodeComposite;

import java.io.File;

public class Workspace extends RuNodeComposite {

    private File workspaceFile;

    public Workspace(String name) {
        super(name, null);
    }

    @Override
    public void addChild(RuNode child) {
        if(child instanceof Project){
            Project project = (Project) child;
            if(!this.getChildren().contains(project)){
                this.getChildren().add(project);
                setAkcija("ADD");
                notifySubscribers(project);
            }
        }
    }

    @Override
    public void deleteChild(RuNode child) {
        if(child instanceof Project){
            Project project = (Project) child;
            if(this.getChildren().contains(project)){
                this.getChildren().remove(project);
                setAkcija("DELETE");
                notifySubscribers(project);
            }
        }
    }

    public File getWorkspaceFile() {
        return workspaceFile;
    }

    public void setWorkspaceFile(File workspaceFile) {
        this.workspaceFile = workspaceFile;
    }


}
