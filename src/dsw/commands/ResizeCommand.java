package dsw.commands;

import dsw.AppCore;
import dsw.repository.Page;
import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.util.List;

public class ResizeCommand implements ICommand{

    private Page page;
    private Point lastPosition;
    private List<Dimension> dimensions;

    public ResizeCommand(Page page, Point point2D, List<Dimension> dimensions){
        this.page = page;
        this.lastPosition = point2D;
        this.dimensions= dimensions;
    }

    @Override
    public void doCommand() {
        AppCore.getInstance().getSlotHandler().resize(page.getSelectedList(), lastPosition);
    }

    @Override
    public void undoCommand() {
        int i = 0;
        for(RuNode node : page.getSelectedList()){
            Slot slot = (Slot) node;
            slot.setSize(dimensions.get(i));
            i++;
        }
    }
}
