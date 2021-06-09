package dsw.commands;

import dsw.AppCore;
import dsw.repository.Page;
import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.util.List;

public class RotateCommand implements ICommand{

    private Page page;
    private Point lastPosition;
    private List<Integer> angles;

    public RotateCommand(Page page, Point point2D, List<Integer> angles){
        this.page = page;
        this.lastPosition = point2D;
        this.angles = angles;
    }

    @Override
    public void doCommand() {
        AppCore.getInstance().getSlotHandler().rotate(page.getSelectedList(), lastPosition);
    }

    @Override
    public void undoCommand() {
        int i = 0;
        for(RuNode node : page.getSelectedList()){
            Slot slot = (Slot) node;
            slot.setAngle(angles.get(i));
            i++;
        }
    }
}
