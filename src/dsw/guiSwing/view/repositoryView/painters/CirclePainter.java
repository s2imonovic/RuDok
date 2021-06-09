package dsw.guiSwing.view.repositoryView.painters;

import dsw.repository.slot.CircleSlot;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class CirclePainter extends SlotPainter{

    public CirclePainter(Slot slot){
        super(slot);

        CircleSlot or = (CircleSlot) slot;
        Shape shape = getShape();

        shape = new GeneralPath();
        ((GeneralPath)shape).moveTo(or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());

        ((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY(),
                or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight()/2);

        ((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight(),
                or.getPosition().getX()+or.getSize().getWidth()/2, or.getPosition().getY()+or.getSize().getHeight());

        ((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight(),
                or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight()/2);


        ((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY(),
                or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());

        setShape(shape);
    }

}
