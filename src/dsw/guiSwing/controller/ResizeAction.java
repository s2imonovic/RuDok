package dsw.guiSwing.controller;

import dsw.guiSwing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ResizeAction extends AbstractRudokAction{

    public ResizeAction() {
        putValue(SMALL_ICON, loadIcon("imagess/resize.png"));
        putValue(NAME, "Resize");
        putValue(SHORT_DESCRIPTION, "Resize");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getOpenPageView() == null){
            return;
        }
        MainFrame.getInstance().getOpenPageView().startResizeState();
    }

}
