package dsw.repository.slotFactory;

import dsw.repository.node.RuNode;
import dsw.repository.slot.CircleSlot;
import dsw.repository.slot.Slot;

public class CircleFactory extends AbstractSlotFactory{
    @Override
    public Slot createSlot(String name, RuNode parent) {
        Slot slot = new CircleSlot(name, parent);
        return slot;
    }
}
