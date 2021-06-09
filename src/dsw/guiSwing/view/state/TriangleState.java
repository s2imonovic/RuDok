package dsw.guiSwing.view.state;

import dsw.AppCore;
import dsw.commands.AddSlotCommand;
import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.PageView;
import dsw.guiSwing.view.repositoryView.painters.SlotPainter;
import dsw.guiSwing.view.repositoryView.painters.TrianglePainter;
import dsw.repository.slot.Slot;
import dsw.repository.slot.SlotType;
import dsw.repository.slotFactory.AbstractSlotFactory;
import dsw.repository.slotFactory.TriangleFactory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class TriangleState implements State{

    private PageView view;
    private static int br = 0;

    public TriangleState(PageView view){
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
            AppCore.getInstance().getCommand().getCommandManager().addComand(new AddSlotCommand(view.getPage(), SlotType.TRIANGLE, position));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
