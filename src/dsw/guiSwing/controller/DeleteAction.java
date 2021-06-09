package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.Workspace;

import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractRudokAction {

    public DeleteAction() {
        putValue(SMALL_ICON, loadIcon("imagess/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTree().getSelected() == null){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.SELEKT);
            return;
        }

        if(MainFrame.getInstance().getTree().getSelected() instanceof Workspace){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.ROOT);
            return;
        }

        MainFrame.getInstance().getTree().delete(MainFrame.getInstance().getTree().getSelected());
    }

}
