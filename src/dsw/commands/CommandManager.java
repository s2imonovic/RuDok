package dsw.commands;

import dsw.core.Command;
import dsw.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements Command {

    private List<ISubscriber> subscribers;
    private List<ICommand> commands = new ArrayList<>();
    private int currentComand = 0;
    private String akcija;

    public void addComand(ICommand command){
        while(currentComand < commands.size()){
            commands.remove(currentComand);
        }
        commands.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentComand < commands.size()){
            commands.get(currentComand++).doCommand();
            setAkcija("UNDO-TRUE");
            notifySubscribers(akcija);
        }
        if(currentComand == commands.size()){
            setAkcija("REDO-FALSE");
            notifySubscribers(akcija);
        }
    }

    public void undoCommand(){
        if(currentComand > 0){
            commands.get(--currentComand).undoCommand();
            setAkcija("REDO-TRUE");
            notifySubscribers(akcija);
        }
        if(currentComand == 0){
            setAkcija("UNDO-FALSE");
            notifySubscribers(akcija);
        }
    }

    @Override
    public CommandManager getCommandManager() {
        return this;
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
            listener.update(notification, null);
        }
    }

    public void setAkcija(String akcija) {
        this.akcija = akcija;
    }

    public List<ICommand> getCommands() {
        return commands;
    }
}
