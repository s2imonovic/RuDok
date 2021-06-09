package dsw.guiSwing.view.repositoryView.painters;

import dsw.repository.slot.RectangleSlot;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class RectanglePainter extends SlotPainter{

    public RectanglePainter(Slot slot) {
        super(slot);

        RectangleSlot rectangle = (RectangleSlot) slot;
        Shape shape = getShape();

        shape = new GeneralPath();

        ((GeneralPath)shape).moveTo(rectangle.getPosition().x,rectangle.getPosition().y);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y+rectangle.getSize().height);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x,rectangle.getPosition().y+rectangle.getSize().height);

        ((GeneralPath)shape).closePath();

        setShape(shape);
    }


}
