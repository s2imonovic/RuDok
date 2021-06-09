package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.Project;

import java.awt.event.ActionEvent;

public class OpenAction extends AbstractRudokAction{

    public OpenAction() {
        putValue(SMALL_ICON, loadIcon("imagess/tab.png"));
        putValue(NAME, "Open");
        putValue(SHORT_DESCRIPTION, "Open");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(!(MainFrame.getInstance().getTree().getSelected() instanceof Project)){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.SELEKT);
            return;
        }

        Project project = (Project)  MainFrame.getInstance().getTree().getSelected();

        MainFrame.getInstance().getSplit().setRightComponent(MainFrame.getInstance().getProjectView(project));
    }

}
