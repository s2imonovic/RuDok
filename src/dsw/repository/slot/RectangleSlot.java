package dsw.repository.slot;

import dsw.repository.node.RuNode;


public class RectangleSlot extends Slot{

    public RectangleSlot(String name, RuNode parent) {
        super(name, parent);
        setType(SlotType.RECTANGLE);
    }
}
