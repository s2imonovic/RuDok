package dsw.repository.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode implements Serializable {

    private List<RuNode> children;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
        children = new ArrayList<>();
    }

    public RuNodeComposite(String name, RuNode parent, List<RuNode> children){
        super(name, parent);
        this.children = children;
    }

    public abstract void addChild(RuNode child);

    public abstract void deleteChild(RuNode child);

    public RuNode getChildByName(String name){
        for(RuNode child : this.children){
            if(name.equals(child.getName())){
                return child;
            }
        }
        return null;
    }

    public List<RuNode> getChildren() {
        return children;
    }
}
