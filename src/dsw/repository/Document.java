package dsw.repository;

import dsw.repository.node.RuNode;
import dsw.repository.node.RuNodeComposite;

public class Document extends RuNodeComposite {

    public Document(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if(child instanceof Page){
            Page page = (Page) child;
            if(!this.getChildren().contains(page)){
                this.getChildren().add(page);
                setAkcija("ADD");
                notifySubscribers(page);
            }
        }
    }

    @Override
    public void deleteChild(RuNode child) {
        if(child instanceof Page){
            Page page = (Page) child;
            if(this.getChildren().contains(page)){
                this.getChildren().remove(page);
                setAkcija("DELETE");
                notifySubscribers(page);
            }
        }
    }

}
