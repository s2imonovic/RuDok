package dsw.guiSwing.view.state;

import dsw.AppCore;
import dsw.commands.DeleteCommand;
import dsw.guiSwing.view.repositoryView.PageView;

import java.awt.event.MouseEvent;

public class DeleteState implements State{

    private PageView view;

    public DeleteState(PageView view) {
        this.view = view;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        AppCore.getInstance().getCommand().getCommandManager().addComand(new DeleteCommand(view.getPage() , e.getPoint()));
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
