package dsw.commands;

import dsw.repository.Page;
import dsw.repository.slot.Slot;

import java.awt.*;

public class DeleteCommand implements ICommand{

    private Page page;
    private Point lastPosition;

    public DeleteCommand(Page page, Point point2D){
        this.page = page;
        this.lastPosition = point2D;
    }

    @Override
    public void doCommand() {
        for(Slot slot : page.getSelectedList()){
            page.deleteChild(slot);
        }
    }

    @Override
    public void undoCommand() {
        for(Slot slot : page.getSelectedList()){
            page.addToTree(slot);
        }
    }
}
