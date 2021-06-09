package dsw.repository.slot;

import dsw.repository.node.RuNode;

public class CircleSlot extends Slot{

    public CircleSlot(String name, RuNode parent) {
        super(name, parent);
        setType(SlotType.CIRCLE);
    }
}
