package dsw.guiSwing.view.state;

import dsw.AppCore;
import dsw.commands.AddSlotCommand;
import dsw.commands.MoveCommand;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.PageView;
import dsw.repository.slot.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MoveState implements State{

    private PageView view;
    private List<Point> points;

    public MoveState(PageView view) {
        this.view = view;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        this.points = view.getPoints();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        List<Slot> slots = MainFrame.getInstance().getOpenPageView().getPage().getSelectedList();

        if(slots.isEmpty()){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.SHAPE);
            return;
        }

        AppCore.getInstance().getSlotHandler().move(slots, e.getPoint());
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        AppCore.getInstance().getCommand().getCommandManager().addComand(new MoveCommand(view.getPage() , e.getPoint(), points));
    }

}
