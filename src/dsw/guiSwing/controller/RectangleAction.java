package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.guiSwing.view.MainFrame;

import java.awt.event.ActionEvent;

public class RectangleAction extends AbstractRudokAction{

    public RectangleAction() {
        putValue(SMALL_ICON, loadIcon("imagess/rectangle.png"));
        putValue(NAME, "Draw rectangle");
        putValue(SHORT_DESCRIPTION, "Draw rectangle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getOpenPageView() == null){
            return;
        }
        MainFrame.getInstance().getOpenPageView().startRectangleState();
    }
}
