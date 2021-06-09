package dsw.repository.node;

import dsw.observer.IPublisher;
import dsw.observer.ISubscriber;
import dsw.repository.Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNode implements IPublisher, Serializable {

    private String name;
    private RuNode parent;
    transient private List<ISubscriber> subscribers;
    private String akcija;

    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber listener : subscribers){
            listener.update(notification, this.akcija);

        }
    }

    public String getName() {
        return name;
    }

    public RuNode getParent() {
        return parent;
    }

    public void setName(String name) {
        this.name = name;
        this.setAkcija("RENAME");
        notifySubscribers(this);
    }

    public String getAkcija() {
        return akcija;
    }

    public void setAkcija(String akcija) {
        this.akcija = akcija;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof RuNode){
            RuNode node = (RuNode) o;
            return this.getName().equals(node.getName());
        }

        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }

}

