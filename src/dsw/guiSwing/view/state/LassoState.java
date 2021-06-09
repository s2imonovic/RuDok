package dsw.guiSwing.view.state;

import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.PageView;
import dsw.guiSwing.view.repositoryView.painters.SlotPainter;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class LassoState implements State{

    private PageView view;

    public LassoState(PageView view){
        this.view = view;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Rectangle2D rectangle2D = new Rectangle2D.Double();

        double x = Math.min(view.getLastPosition().getX(), e.getX());
        double y = Math.min(view.getLastPosition().getY(), e.getY());
        double width = Math.abs(view.getLastPosition().getX() - e.getX());
        double height = Math.abs(view.getLastPosition().getY() - e.getY());

        rectangle2D.setFrame(x, y, width, height);

        view.setSelectionRec(rectangle2D);
        view.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        for(SlotPainter painter : MainFrame.getInstance().getSlotPaintersByPage(view.getPage())){
            Slot slot = MainFrame.getInstance().getSlot(painter);

            if(slot == null || view.getSelectionRec() == null)
                return;

            if(view.getSelectionRec().intersects(slot.getPosition().getX(), slot.getPosition().getY(), slot.getSize().width, slot.getSize().height)){
                view.getPage().getSelectedList().add(slot);
                painter.setPaint(Color.YELLOW);
                slot.addSubscriber(view);
            }
        }
        view.setSelectionRec(null);
        view.repaint();
        view.startSelectState(); // ovo je kada dodje do otpustanja misa ako opet hocemo da povucemo lasso krene iz novih kordinata
    }
}
