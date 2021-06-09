package dsw.repository.slot;

import dsw.repository.node.RuNode;


public class TriangleSlot extends Slot{

    public TriangleSlot(String name, RuNode parent) {
        super(name, parent);
        setType(SlotType.TRIANGLE);
    }
}
