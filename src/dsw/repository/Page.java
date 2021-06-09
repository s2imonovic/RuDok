package dsw.repository;

import dsw.repository.node.RuNode;
import dsw.repository.node.RuNodeComposite;
import dsw.repository.slot.Slot;

import java.util.ArrayList;
import java.util.List;

public class Page extends RuNodeComposite {

    private List<Slot> selectedList = new ArrayList<>();

    public Page(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if(child instanceof Slot){
            Slot slot = (Slot) child;
            if(!(this.getChildren().contains(slot))){
                this.getChildren().add(slot);
                setAkcija("ADD");
                notifySubscribers(slot);
            }

        }
    }

    @Override
    public void deleteChild(RuNode child) {
        if(child instanceof Slot){
            Slot slot = (Slot) child;
            if(this.getChildren().contains(slot)){
                this.getChildren().remove(slot);
                setAkcija("DELETE");
                notifySubscribers(slot);
            }
        }
    }

    public void addToTree(Slot slot){
        setAkcija("TREE");
        notifySubscribers(slot);
    }

    public List<Slot> getSelectedList() {
        setAkcija("SELECT");
        notifySubscribers(this);
        return selectedList;
    }
}

