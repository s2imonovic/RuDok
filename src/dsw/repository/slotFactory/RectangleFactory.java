package dsw.repository.slotFactory;

import dsw.repository.node.RuNode;
import dsw.repository.slot.RectangleSlot;
import dsw.repository.slot.Slot;

public class RectangleFactory extends AbstractSlotFactory{

    @Override
    public Slot createSlot(String name, RuNode parent) {
        Slot slot = new RectangleSlot(name, parent);
        return slot;
    }
}
