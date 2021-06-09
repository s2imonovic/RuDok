package dsw.core;

import dsw.repository.slot.Slot;

import java.awt.*;
import java.util.List;

public interface SlotHandler {
    void resize(List<Slot> selected, Point position);
    void rotate(List<Slot> selected, Point position);
    void move(List<Slot> selected, Point position);
}
