package dsw.guiSwing.view.state;

import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.PageView;
import dsw.guiSwing.view.repositoryView.painters.SlotPainter;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState implements State{

    private PageView view;

    public SelectState(PageView view){
        this.view = view;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();

        if(e.getButton() == MouseEvent.BUTTON1){

            for(SlotPainter painter : MainFrame.getInstance().getSlotPaintersByPage(view.getPage())){
                painter.setPaint(Color.WHITE);
                view.getPage().getSelectedList().remove(MainFrame.getInstance().getSlot(painter));
            }

            for(SlotPainter painter : MainFrame.getInstance().getSlotPaintersByPage(view.getPage())){
                if(painter.elementAt(position)){
                    view.getPage().getSelectedList().add(MainFrame.getInstance().getSlot(painter));
                    painter.setPaint(Color.YELLOW);
                    MainFrame.getInstance().getSlot(painter).addSubscriber(view);
                }

            }


        }

        if(e.getClickCount() == 2){
            for(SlotPainter painter : MainFrame.getInstance().getSlotPaintersByPage(view.getPage())){
                if(painter.elementAt(position)){
                    Slot slot = MainFrame.getInstance().getSlot(painter);
                    MainFrame.getInstance().getEditor().show(slot);
                }
            }
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        view.startLassoState();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}


