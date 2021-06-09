package dsw.commands;

import dsw.repository.Page;
import dsw.repository.slot.Slot;
import dsw.repository.slot.SlotType;
import dsw.repository.slotFactory.AbstractSlotFactory;
import dsw.repository.slotFactory.CircleFactory;
import dsw.repository.slotFactory.RectangleFactory;
import dsw.repository.slotFactory.TriangleFactory;

import java.awt.*;

public class AddSlotCommand implements ICommand{

    private Slot slot = null;
    private SlotType slotType;
    private Page page;
    private Point lastPosition;
    private static int br = 0;

    public AddSlotCommand(Page page, SlotType type, Point point2D){
        this.page = page;
        this.slotType = type;
        this.lastPosition = point2D;
    }

    @Override
    public void doCommand() {
        if(slot == null){
            if(slotType == SlotType.RECTANGLE){
                AbstractSlotFactory slotFactory = new RectangleFactory();
                slot = slotFactory.makeSlot("Rectangle " + br, page, new Dimension(100,50), lastPosition, 0);
            } else if(slotType == SlotType.TRIANGLE){
                AbstractSlotFactory slotFactory = new TriangleFactory();
                slot = slotFactory.makeSlot("Triangle " + br, page, new Dimension(100,50), lastPosition, 0);
            } else{
                AbstractSlotFactory slotFactory = new CircleFactory();
                slot = slotFactory.makeSlot("Circle " + br, page, new Dimension(100,50), lastPosition, 0);
            }

            br++;
        }

        page.addToTree(slot);
    }

    @Override
    public void undoCommand() {
        page.deleteChild(slot);
    }
}
