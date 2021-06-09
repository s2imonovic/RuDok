package dsw.commands;

import dsw.AppCore;
import dsw.repository.Page;
import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.util.List;

public class MoveCommand implements ICommand{

    private Page page;
    private Point lastPosition;
    private List<Point> points;

    public MoveCommand(Page page, Point point2D, List<Point> points){
        this.page = page;
        this.lastPosition = point2D;
        this.points = points;
    }

    @Override
    public void doCommand() {
        AppCore.getInstance().getSlotHandler().move(page.getSelectedList(), lastPosition);
    }

    @Override
    public void undoCommand() {
        int i = 0;
        for(RuNode node : page.getSelectedList()){
            Slot slot = (Slot) node;
            slot.setPosition(points.get(i));
            i++;
        }
    }
}
