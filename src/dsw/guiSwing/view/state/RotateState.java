package dsw.guiSwing.view.state;

import dsw.AppCore;
import dsw.commands.MoveCommand;
import dsw.commands.ResizeCommand;
import dsw.commands.RotateCommand;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.PageView;
import dsw.repository.slot.Slot;

import java.awt.event.MouseEvent;
import java.util.List;

public class RotateState implements State{

    private PageView view;
    private List<Integer> angles;

    public RotateState(PageView view) {
        this.view = view;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.angles = view.getAngles();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        List<Slot> slots = MainFrame.getInstance().getOpenPageView().getPage().getSelectedList();

        if(slots.isEmpty()){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.SHAPE);
            return;
        }

        AppCore.getInstance().getSlotHandler().rotate(slots, e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        AppCore.getInstance().getCommand().getCommandManager().addComand(new RotateCommand(view.getPage(), e.getPoint(), angles));
    }
}
