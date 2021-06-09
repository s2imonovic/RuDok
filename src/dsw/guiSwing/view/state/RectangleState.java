package dsw.guiSwing.view.state;

import dsw.AppCore;
import dsw.commands.AddSlotCommand;
import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.PageView;
import dsw.guiSwing.view.repositoryView.painters.SlotPainter;
import dsw.repository.slot.SlotType;

import java.awt.*;
import java.awt.event.MouseEvent;

public class RectangleState implements State{

    private PageView view;

    public RectangleState(PageView view){
        this.view = view;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        for(SlotPainter slotPainter : MainFrame.getInstance().getSlotovi().values()){
            if(slotPainter.elementAt(position))
                return;
        }

        if(e.getButton() == MouseEvent.BUTTON1){
            AppCore.getInstance().getCommand().getCommandManager().addComand(new AddSlotCommand(view.getPage(), SlotType.RECTANGLE, position));
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
