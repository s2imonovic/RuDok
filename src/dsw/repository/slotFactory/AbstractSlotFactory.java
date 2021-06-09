package dsw.repository.slotFactory;

import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;

import java.awt.*;

public abstract class AbstractSlotFactory {

    public Slot makeSlot(String name, RuNode parent, Dimension size, Point position, int angle){
        Slot slot;
        slot = createSlot(name, parent);
        slot.setSize(size);
        slot.setPosition(position);
        slot.setAngle(angle);
        return slot;
    }

    public abstract Slot createSlot(String name, RuNode parent);
}
