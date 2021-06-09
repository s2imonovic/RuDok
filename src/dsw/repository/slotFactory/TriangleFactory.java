package dsw.repository.slotFactory;

import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;
import dsw.repository.slot.TriangleSlot;

public class TriangleFactory extends AbstractSlotFactory{
    @Override
    public Slot createSlot(String name, RuNode parent) {
        Slot slot = new TriangleSlot(name, parent);

        return slot;
    }
}
