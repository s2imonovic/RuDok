package dsw.guiSwing.controller;

import dsw.guiSwing.view.MainFrame;

import java.awt.event.ActionEvent;

public class RotateAction extends AbstractRudokAction{

    public RotateAction() {
        putValue(SMALL_ICON, loadIcon("imagess/rotate.png"));
        putValue(NAME, "Rotate");
        putValue(SHORT_DESCRIPTION, "Rotate");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getOpenPageView() == null){
            return;
        }
        MainFrame.getInstance().getOpenPageView().startRotateState();
    }

}
