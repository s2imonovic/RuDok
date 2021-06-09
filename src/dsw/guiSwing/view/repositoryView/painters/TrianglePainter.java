package dsw.guiSwing.view.repositoryView.painters;

import dsw.repository.slot.Slot;
import dsw.repository.slot.TriangleSlot;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class TrianglePainter extends SlotPainter{

    public TrianglePainter(Slot slot){
        super(slot);

        TriangleSlot triangle = (TriangleSlot) slot;
        Shape shape = getShape();

        shape = new GeneralPath();

        ((GeneralPath)shape).moveTo(triangle.getPosition().x+triangle.getSize().width,triangle.getPosition().y+triangle.getSize().height);

        ((GeneralPath)shape).lineTo(triangle.getPosition().x,triangle.getPosition().y+triangle.getSize().height);

        ((GeneralPath)shape).lineTo(triangle.getPosition().x+triangle.getSize().width / 2,triangle.getPosition().y);

        ((GeneralPath)shape).closePath();

        setShape(shape);
    }

}
