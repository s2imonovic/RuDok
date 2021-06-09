package dsw.repository;

import dsw.repository.node.RuNode;
import dsw.repository.node.RuNodeComposite;

import java.io.File;

public class Project extends RuNodeComposite {

    private File projectFile;
    private transient boolean changed;

    public Project(String name, RuNode parent) {
        super(name, parent);
        this.projectFile = null;
        this.changed = false;
    }

    @Override
    public void addChild(RuNode child) {
        if(child instanceof Document){
            Document document = (Document) child;
            if(!this.getChildren().contains(document)){
                this.getChildren().add(document);
                setAkcija("ADD");
                notifySubscribers(document);
            }
        }
    }

    @Override
    public void deleteChild(RuNode child) {
        if(child instanceof Document){
            Document document = (Document) child;
            if(this.getChildren().contains(document)){
                this.getChildren().remove(document);
                setAkcija("DELETE");
                notifySubscribers(document);
            }
        }
    }

    public File getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        if (!this.changed){
            this.changed = changed;
        }
    }

}
