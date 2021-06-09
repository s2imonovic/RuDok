package dsw.slotHandler;

import dsw.core.SlotHandler;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.util.List;

public class SlotHandlerImpl implements SlotHandler {

    @Override
    public void resize(List<Slot> slots, Point position) {

        //Slotovi se skaliraju u odnosu na slot koji je prvi napravljen

        Dimension dimension = new Dimension();
        double width = position.getX() - slots.get(0).getPosition().getX();
        double height = position.getY() - slots.get(0).getPosition().getY();
        dimension.setSize(width, height);

        for(Slot selected : slots){
            selected.setSize(dimension);
        }
    }

    @Override
    public void rotate(List<Slot> slots, Point position) {

        float angle = (float) Math.toDegrees(Math.atan2(position.y - slots.get(0).getPosition().y, position.x - slots.get(0).getPosition().x));


        for(Slot selected : slots){

            if(angle < 0){
                angle += 360;
            }

            selected.setAngle((int)angle);
        }

    }

    @Override
    public void move(List<Slot> slots, Point position) {
        //Slotovi se pomeraju u odnosu na slot koji je prvi napravljen

        double x = position.getX() - slots.get(0).getPosition().getX();
        double y = position.getY() - slots.get(0).getPosition().getY();

        for(Slot selected : slots){
            Point point = new Point();
            point.setLocation(selected.getPosition().getX() + x, selected.getPosition().getY() + y);
            selected.setPosition(point);
        }
    }

}
