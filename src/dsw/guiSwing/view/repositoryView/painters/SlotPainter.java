package dsw.guiSwing.view.repositoryView.painters;

import dsw.guiSwing.view.MainFrame;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class SlotPainter {

    private Slot slot;
    private Paint paint;
    private Stroke stroke;
    private Shape shape;

    public SlotPainter(Slot slot){
        this.slot = slot;
        this.paint = new Color(255,255,255);
        this.stroke = new BasicStroke(2f);
    }

    public void paint(Graphics graphics, Slot slot){
        Graphics2D g = (Graphics2D) graphics;

        AffineTransform old = g.getTransform();
        g.rotate(Math.toRadians(slot.getAngle()),slot.getPosition().getX(),slot.getPosition().getY());

        g.setPaint(Color.RED);
        g.setStroke(stroke);
        g.draw(getShape());
        g.setPaint(paint);
        g.fill(getShape());

        g.setTransform(old);
        g.setPaint(Color.BLACK);
    }

    public boolean elementAt(Point position){
        return getShape().contains(position);
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Slot getSlot() {
        return slot;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

}
